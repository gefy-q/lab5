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

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: program <data-filename>");
            return;
        }

        try {
            final String dataFile = args[0];

            CollectionController controller = new ArrayListController();
            JsonCollectionControllerRepr.read(new InputStreamReader(new FileInputStream(dataFile)), controller);
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dataFile)));

            Menu menu = new Menu();
            menu.addAction("help", new HelpAction(menu, "", "show help information for available commands"));
            menu.addAction("save", new SaveAction(fileWriter, controller, "", "save data to file"));
            menu.addAction("show", new ShowAction(controller, "", "show dragons"));
            menu.addAction("add", new AddAction(controller, "{element}", "add new element"));
//        menu.addAction("update", new UpdateByIdAction(controller, "id {element}", "update element by id"));
            menu.addAction("remove_by_id", new RemoveByIdAction(controller, "id", "remove element by id"));
            menu.addAction("clear", new ClearAction(controller, "", "clear collection"));
            menu.addAction("execute_script", new ExecuteScriptAction(menu, "file_name", "execute script from file"));
            menu.addAction("exit", new ExitAction("", "exit from program"));

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            try {
                outputWriter.write("Welcome! Enter the command. To show instructions type \"help\"\n");
                outputWriter.flush();
                menu.run(inputReader, outputWriter);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


//        Dragon dragon = new Dragon(1, "hello", new Coordinates(1L, 2), LocalDateTime.now(), 5, "", 5.5, DragonCharacter.GOOD, new DragonCave(5));
//        ArrayList<JsonDragonRepr> dragons = new ArrayList<>();
//        dragons.add(new JsonDragonRepr(dragon));
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.registerModule(new JavaTimeModule());
//            objectMapper.writeValue(new FileWriter("data.json"), dragons);
//        } catch (IOException e) {
//            System.err.println(e.getMessage());;
//        }
    }
}
