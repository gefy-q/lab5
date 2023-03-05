package menu.actions;

import java.io.Writer;
import java.util.Scanner;

public abstract class Action {
    protected final String args;
    protected final String description;

    public Action(String args, String description) {
        // TODO: add validation
        this.args = args;
        this.description = description;
    }

    public String getArgs() {
        return args;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean process(Scanner scanner, Writer writer);
}
