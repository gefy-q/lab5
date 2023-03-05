package representations.console;

import model.DragonCharacter;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleDragonRepr extends ConsoleRepr {
    private Integer id;
    private final String name;
    private final ConsoleCoordinatesRepr coordinates;
    private LocalDateTime creationDate;
    private final Integer age;
    private final String description;
    private final Double wingspan;
    private final DragonCharacter character;
    private final ConsoleDragonCaveRepr cave;

    public ConsoleDragonRepr(String name, ConsoleCoordinatesRepr coordinates, Integer age, String description, Double wingspan, DragonCharacter character, ConsoleDragonCaveRepr cave) {
        this.name = name;
        this.coordinates = coordinates;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.character = character;
        this.cave = cave;
    }

    public ConsoleDragonRepr(Integer id, String name, ConsoleCoordinatesRepr coordinates, LocalDateTime creationDate, Integer age, String description, Double wingspan, DragonCharacter character, ConsoleDragonCaveRepr cave) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.character = character;
        this.cave = cave;
    }

    public String getName() {
        return name;
    }

    public ConsoleCoordinatesRepr getCoordinates() {
        return coordinates;
    }

    public Integer getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public ConsoleDragonCaveRepr getCave() {
        return cave;
    }

    public static ConsoleDragonRepr read(Scanner scanner, Writer writer) throws IOException {
        String name = readName(scanner, writer);
        ConsoleCoordinatesRepr coordinates = readCoordinates(scanner, writer);
        Integer age = readAge(scanner, writer);
        String description = readDescription(scanner, writer);
        Double wingspan = readWingspan(scanner, writer);
        DragonCharacter character = readDragonCharacter(scanner, writer);
        ConsoleDragonCaveRepr cave = readDragonCave(scanner, writer);
        return new ConsoleDragonRepr(name, coordinates, age, description, wingspan, character, cave);
    }

    private static String readName(Scanner scanner, Writer writer) throws IOException {
        while (true) {
            print(writer, "Enter name: ");
            String name = scanner.next().trim();
            if (name.isEmpty()) {
                scanner.next();
                println(writer, "Name cannot be empty");
                continue;
            }
            return name;
        }
    }

    private static ConsoleCoordinatesRepr readCoordinates(Scanner scanner, Writer writer) throws IOException {
        println(writer, "Enter coordinates:");
        return ConsoleCoordinatesRepr.read(scanner, writer);
    }

    private static Integer readAge(Scanner scanner, Writer writer) throws IOException {
        while (true) {
            print(writer, "Enter age: ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                println(writer, "Age must be a positive integer");
                continue;
            }
            int age = scanner.nextInt();
            if (age <= 0) {
                println(writer, "Age must be a positive integer");
                continue;
            }
            return age;
        }
    }

    private static String readDescription(Scanner scanner, Writer writer) throws IOException {
        print(writer, "Enter description: ");
        return scanner.next().trim();
    }

    private static Double readWingspan(Scanner scanner, Writer writer) throws IOException {
        while (true) {
            print(writer, "Enter wingspan: ");
            if (!scanner.hasNextDouble()) {
                scanner.next();
                println(writer, "Wingspan must be a positive float");
                continue;
            }
            double wingspan = scanner.nextDouble();
            if (wingspan <= 0) {
                println(writer, "Wingspan must be a positive float");
                continue;
            }
            return wingspan;
        }
    }

    private static DragonCharacter readDragonCharacter(Scanner scanner, Writer writer) throws IOException {
        println(writer, "Choose dragon character (enter number):");

        DragonCharacter[] characters = DragonCharacter.values();
        for (int i = 0; i < characters.length; ++i) {
            println(writer, String.format("%d. %s", i + 1, characters[i]));
        }

        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.next();
                println(writer, "Number must be a integer");
                continue;
            }
            int index = scanner.nextInt() - 1;
            if (index < 0 || index >= characters.length) {
                println(writer, String.format("Number must be in range [%d, %d]", 1, characters.length));
                continue;
            }
            return characters[index];
        }
    }

    private static ConsoleDragonCaveRepr readDragonCave(Scanner scanner, Writer writer) throws IOException {
        return ConsoleDragonCaveRepr.read(scanner, writer);
    }
}
