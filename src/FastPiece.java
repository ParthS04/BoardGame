import java.awt.*;

public class FastPiece extends Piece{
    public FastPiece(String name, String colour, Point position) {
        super(name, colour, position);
    }

    public void move(String direction, int n){
        if(direction.equals("left")){
            if(super.getPosition().x-n < 0){
                System.out.println("out of bound error");
            }
            else{
                super.getPosition().move(super.getPosition().x-n, super.getPosition().y);
            }
        }

        else if(direction.equals("right")){
            if(super.getPosition().x+n > 7){
                System.out.println("out of bound error");
            }
            else{
                super.getPosition().move(super.getPosition().x+n, super.getPosition().y);
            }
        }
    }

    public String toString(){
        return this.getName()+this.getColour()+"F";
    }
}