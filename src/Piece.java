import java.awt.*;

public class Piece {
    private String name;
    private String colour;
    private Point position;

    public Piece(String name , String colour, Point position){
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public Point getPosition() {
        return position;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", position=" + position +
                '}';
    }
}
