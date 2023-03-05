package representations.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Coordinates;
import model.Dragon;
import model.DragonCave;
import model.DragonCharacter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;

public class JsonDragonRepr {
    private final Integer id;
    private final String name;
    private final JsonCoordinatesRepr coordinates;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;
    private final Integer age;
    private final String description;
    private final Double wingspan;
    private final DragonCharacter character;
    private final JsonDragonCaveRepr cave;

    public JsonDragonRepr(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Integer age, String description, Double wingspan, DragonCharacter character, DragonCave cave) {
        this.id = id;
        this.name = name;
        this.coordinates = new JsonCoordinatesRepr(coordinates);
        this.creationDate = creationDate;
        this.age = age;
        this.description = description;
        this.wingspan = wingspan;
        this.character = character;
        this.cave = new JsonDragonCaveRepr(cave);
    }

    public JsonDragonRepr(Dragon dragon) {
        this(dragon.getId(), dragon.getName(), dragon.getCoordinates(), dragon.getCreationDate(), dragon.getAge(), dragon.getDescription(), dragon.getWingspan(), dragon.getCharacter(), dragon.getCave());
    }

    public Dragon toDragon() {
        return new Dragon(id, name, coordinates.toCoordinates(), creationDate, age, description, wingspan, character, cave.toDragonCave());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JsonCoordinatesRepr getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public JsonDragonCaveRepr getCave() {
        return cave;
    }

    public static Dragon read(Reader reader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(reader, JsonDragonRepr.class).toDragon();
    }

    public static void write(Writer writer, Dragon dragon) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(writer, new JsonDragonRepr(dragon));
    }
}
