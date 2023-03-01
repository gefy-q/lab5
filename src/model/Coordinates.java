package model;

public class Coordinates {
    private Long x; //Поле не может быть null
    private double y;

    public Coordinates(Long x, double y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
