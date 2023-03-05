package representations.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Coordinates;
import model.DragonCave;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class JsonDragonCaveRepr {
    private final long numberOfTreasures;

    public JsonDragonCaveRepr(long numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public JsonDragonCaveRepr(DragonCave dragonCave) {
        this(dragonCave.getNumberOfTreasures());
    }

    public DragonCave toDragonCave() {
        return new DragonCave(numberOfTreasures);
    }

    public long getNumberOfTreasures() {
        return this.numberOfTreasures;
    }

    public static DragonCave read(Reader reader) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(reader, JsonDragonCaveRepr.class).toDragonCave();
    }

    public static void write(Writer writer, DragonCave cave) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(writer, new JsonDragonCaveRepr(cave));
    }
}