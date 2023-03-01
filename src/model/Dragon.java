package model;

import java.time.LocalDateTime;

public class Dragon {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой

    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле не может быть null
    private String description; //Поле не может быть null
    private Double wingspan; //Значение поля должно быть больше 0, Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле не может быть null

    public Dragon(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Integer age,
                  String description, Double wingspan, DragonCharacter character, DragonCave cave) {
        // TODO: validate fields
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
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

    public DragonCave getCave() {
        return cave;
    }
}