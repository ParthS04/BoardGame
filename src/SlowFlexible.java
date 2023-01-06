import java.awt.*;

public class SlowFlexible extends SlowPiece{

    public SlowFlexible(String name, String colour, Point position) {
        super(name, colour, position);
    }

    @Override
    public void move(String direction) {
        super.move(direction);

        if(direction.equals("up")){
            if(super.getPosition().y-1 < 0){
                System.out.println("out of bound error");
            }
            else{
                super.getPosition().move(super.getPosition().x , super.getPosition().y-1);
            }
        }

        else if(direction.equals("down")){
            if(super.getPosition().y+1 > 7){
                System.out.println("out of bound error");
            }
            else{
                super.getPosition().move(super.getPosition().x , super.getPosition().y+1);
            }
        }
    }

    public String toString(){
        return this.getName()+this.getColour()+"SF";
    }
}