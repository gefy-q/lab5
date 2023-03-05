package menu.actions;

import controllers.CollectionController;

import java.io.Writer;
import java.util.Scanner;

public class RemoveByIdAction extends Action {
    private final CollectionController controller;

    public RemoveByIdAction(CollectionController controller, String args, String description) {
        super(args, description);
        this.controller = controller;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) {
        controller.removeById(scanner.nextInt());
        return true;
    }
}
