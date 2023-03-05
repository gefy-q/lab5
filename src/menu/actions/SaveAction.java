package menu.actions;

import controllers.CollectionController;
import representations.json.JsonCollectionControllerRepr;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class SaveAction extends Action {
    private final Writer fileWriter;
    private final CollectionController controller;

    public SaveAction(Writer fileWriter, CollectionController controller, String args, String description) {
        super(args, description);
        this.fileWriter = fileWriter;
        this.controller = controller;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) throws IOException {
        JsonCollectionControllerRepr.write(fileWriter, controller);
        writer.write("Successfully saved\n");
        return true;
    }
}
