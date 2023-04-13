/*
Считывает файл по полученному пути и заполняет коллекцию, если файла нет - возвращает ошибку
После вызывает view-menu где происходят основные действия
 */

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
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: program <data-filename>");
            return;
        }

        final Path dataFile = Paths.get(args[0]); // "C:\\Users\\ASUS\\OneDrive\\Рабочий стол\\учеба\\прога\\352.json"
        CollectionController controller = new ArrayListController();

        try {
            JsonCollectionControllerRepr.read(new InputStreamReader(new FileInputStream(dataFile.toString())), controller);
        } catch (IOException e) {
            System.err.println("Error: Cannot read data file.");
            readFile(controller);
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        View view = new View(dataFile, controller);
        view.run(inputReader, outputWriter);


    }

    private static void readFile(CollectionController controller) {
        try {
            Scanner scanner = new Scanner(System.in);
            String name = readName(scanner);
            JsonCollectionControllerRepr.read(new InputStreamReader(new FileInputStream(name.toString())), controller);
        } catch (IOException e) {
            System.err.println("Error: Cannot read data file.");
            readFile(controller);
        }
    }

    private static String readName(Scanner scanner) throws IOException {
        while (true) {
            String name;
            System.err.println("Enter path to data file: ");
            while (scanner.hasNextLine()) {
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.err.println("It cannot be empty");
                    continue;
                }
                return name;
            }
        }
    }
}