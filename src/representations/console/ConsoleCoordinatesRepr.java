package representations.console;

import model.Coordinates;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ConsoleCoordinatesRepr extends ConsoleRepr {
    private final Long x;
    private final double y;

    public ConsoleCoordinatesRepr(Long x, double y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static ConsoleCoordinatesRepr read(Scanner scanner, Writer writer) throws IOException {
        return new ConsoleCoordinatesRepr(readX(scanner, writer), readY(scanner, writer));
    }

    private static Long readX(Scanner scanner, Writer writer) throws IOException {
        while (true) {
            print(writer, "Enter X coordinate: ");
            if (!scanner.hasNextLong()) {
                scanner.next();
                println(writer, "X coordinate must be an integer");
                continue;
            }
            return scanner.nextLong();
        }
    }

    private static double readY(Scanner scanner, Writer writer) throws IOException {
        while (true) {
            print(writer, "Enter Y coordinate: ");
            if (!scanner.hasNextDouble()) {
                scanner.next();
                println(writer, "Y coordinate must be an float");
                continue;
            }
            return scanner.nextDouble();
        }
    }
}
