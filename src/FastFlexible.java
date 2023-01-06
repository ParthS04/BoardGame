import java.awt.*;

public class FastFlexible extends FastPiece{

    public FastFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    @Override
    public void move(String direction, int n) {
        super.move(direction, n);

        if(direction.equals("up")){
            if(super.getPosition().y-n < 0){
                System.out.println("out of bound error");
            }
            else{
                super.getPosition().move(super.getPosition().x , super.getPosition().y-n);
            }
        }

        else if(direction.equals("down")){
            if(super.getPosition().y+n > 7){
                System.out.println("out of bound error");
            }
            else {
                super.getPosition().move(super.getPosition().x, super.getPosition().y+n);
            }
        }
    }
}