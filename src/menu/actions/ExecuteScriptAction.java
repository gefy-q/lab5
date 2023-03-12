package menu.actions;

import java.io.*;
import java.util.Scanner;

import menu.Menu;

public class ExecuteScriptAction extends Action {
    Menu menu;

    public ExecuteScriptAction(Menu menu, String args, String description) {
        super(args, description);
        this.menu = menu;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) throws IOException {
        menu.run(new InputStreamReader(new FileInputStream(scanner.next())), writer);
        return true;
    }
}
