package menu.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.CollectionController;
import model.Coordinates;
import model.Dragon;
import model.DragonCave;
import representations.console.ConsoleCoordinatesRepr;
import representations.console.ConsoleDragonCaveRepr;
import representations.console.ConsoleDragonRepr;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class AddAction extends Action {
    private final CollectionController controller;

    public AddAction(CollectionController controller, String args, String description) {
        super(args, description);
        this.controller = controller;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) throws IOException {
        writer.write("Enter dragon fields\n");
        writer.flush();
        controller.add(ConsoleDragonRepr.readAsDragon(scanner, writer, controller.generateId()));
        return true;
    }
}
