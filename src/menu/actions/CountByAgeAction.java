package menu.actions;

import controllers.CollectionController;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CountByAgeAction extends Action {
    private final CollectionController controller;

    public CountByAgeAction(CollectionController controller, String args, String description) {
        super(args, description);
        this.controller = controller;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) throws IOException {
        if (!scanner.hasNextInt()) {
            writer.write("Age must be an positive integer\n");
            writer.flush();
            scanner.next();
            return true;
        }

        int age = scanner.nextInt();
        writer.write(String.format("With this age found %d dragons\n", controller.countByAge(age)));
        return true;
    }
}
