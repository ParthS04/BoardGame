import java.awt.*;

public class SlowPiece extends Piece {
    public SlowPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

    public void move(String direction){
        if(direction.equals("left")){
            if(super.getPosition().x-1 < 0){
                System.out.println("out of bound error");
            }
            else {
                super.getPosition().move(super.getPosition().x-1, super.getPosition().y);
            }
        }

        else if(direction.equals("right")){
            if(super.getPosition().x+1 > 7){
                System.out.println("out of bound error");
            }
            else {
                super.getPosition().move(super.getPosition().x + 1, super.getPosition().y);
            }
        }
    }

    public String toString(){
        return this.getName()+this.getColour()+"S";
    }
}
