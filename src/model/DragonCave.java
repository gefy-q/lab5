package model;

public class DragonCave {
    private long numberOfTreasures; //Значение поля должно быть больше 0

    public DragonCave(long numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    public long getNumberOfTreasures() {
        return numberOfTreasures;
    }
}
