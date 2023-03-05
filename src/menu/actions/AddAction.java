package menu.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.CollectionController;
import model.Coordinates;
import model.Dragon;
import model.DragonCave;
import representations.console.ConsoleCoordinatesRepr;
import representations.console.ConsoleDragonCaveRepr;
import representations.console.ConsoleDragonRepr;

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
    public boolean process(Scanner scanner, Writer writer) {
        try {
            writer.write("Enter dragon fields\n");
            writer.flush();
            ConsoleDragonRepr dragonRepr = ConsoleDragonRepr.read(scanner, writer);
            Integer id;
            do {
                id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
            } while (controller.containsId(id));

            ConsoleCoordinatesRepr coordinatesRepr = dragonRepr.getCoordinates();
            Coordinates coordinates = new Coordinates(coordinatesRepr.getX(), coordinatesRepr.getY());

            ConsoleDragonCaveRepr caveRepr = dragonRepr.getCave();
            DragonCave cave = new DragonCave(caveRepr.getNumberOfTreasures());

            controller.add(new Dragon(id, dragonRepr.getName(), coordinates, LocalDateTime.now(), dragonRepr.getAge(), dragonRepr.getDescription(), dragonRepr.getWingspan(), dragonRepr.getCharacter(), cave));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            // TODO: add exception handling
        }
        return true;
    }
}
