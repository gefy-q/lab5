package menu;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import menu.actions.Action;

public class Menu {
    private final HashMap<String, Action> actions;

    public Menu() {
        this.actions = new HashMap<String, Action>();
    }

    public void addAction(String name, Action action) {
        if (this.actions.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Action \"%s\" has been added already", name));
        }
        this.actions.put(name, action);
    }

    public void showInstructions(Writer writer) {
        if (actions.isEmpty()) {
            return;
        }

        int actionsWidth = 0;
        int argsWidth = 0;

        for (HashMap.Entry<String, Action> entry : actions.entrySet()) {
            actionsWidth = Math.max(actionsWidth, entry.getKey().length());
            argsWidth = Math.max(argsWidth, entry.getValue().getArgs().length());
        }

        try {
            writer.write("Available commands:\n");
            for (HashMap.Entry<String, Action> entry : actions.entrySet()) {
                Action action = entry.getValue();
                writer.write(String.format(
                        "%-" + actionsWidth + "s\t%-" + argsWidth + "s\t%s\n",
                        entry.getKey(),
                        action.getArgs(),
                        action.getDescription()
                ));
            }
            writer.flush();
        } catch (IOException e) {
            // TODO: add exception handling
            System.err.println(e.getMessage());
        }
    }

    public void run(Reader reader, Writer writer) {
        try (Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNext()) {
                if (!parseAction(scanner, writer)) {
                    break;
                }
            }
        }
    }

    private boolean parseAction(Scanner scanner, Writer writer) {
        try {
            String actionName = scanner.next();
            if (actions.containsKey(actionName)) {
                return actions.get(actionName).process(scanner, writer);
            } else {
                writer.write(String.format("Command %s has not been found\n", actionName));
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            // TODO: add exception handling
        }
        return true;
    }
}
