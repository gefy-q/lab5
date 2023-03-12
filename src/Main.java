import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import controllers.CollectionController;
import menu.Menu;
import menu.actions.*;
import controllers.ArrayListController;
import model.Coordinates;
import model.Dragon;
import model.DragonCave;
import model.DragonCharacter;
import representations.json.JsonCollectionControllerRepr;
import representations.json.JsonDragonRepr;
import ui.View;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: program <data-filename>");
            return;
        }

        final Path dataFile = Paths.get(args[0]);
        CollectionController controller = new ArrayListController();

        try {
            JsonCollectionControllerRepr.read(new InputStreamReader(new FileInputStream(dataFile.toString())), controller);
        } catch (IOException e) {
            System.err.println("Error: Cannot read data file.");
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        View view = new View(dataFile, controller);
        view.run(inputReader, outputWriter);
    }
}
