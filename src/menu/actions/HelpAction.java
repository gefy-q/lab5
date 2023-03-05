package menu.actions;

import menu.Menu;

import java.io.Writer;
import java.util.Scanner;

public class HelpAction extends Action {
    private Menu menu;

    public HelpAction(Menu menu, String args, String description) {
        super(args, description);
        this.menu = menu;
    }

    @Override
    public boolean process(Scanner scanner, Writer writer) {
        menu.showInstructions(writer);
        return true;
    }
}
