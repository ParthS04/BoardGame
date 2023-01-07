import java.awt.Point;
import java.util.Scanner;

public class GameDemo {
    public GameDemo() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board gameBoard = new Board();
        System.out.println("Enter a command (type help for details): ");

        for(String command = in.nextLine(); !command.equals("exit"); command = in.nextLine()) {
            String[] split = command.split(" ");
            Point pos;
            if (split[0].equals("create")) {
                pos = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                if (Board.board[pos.x][pos.y] != null) {
                    System.out.println("Error: there is already a piece on this position");
                    System.out.println("Enter a command (type help for details): ");
                }
                else {
                    System.out.println("Enter a name for the new piece");
                    String name = in.next();
                    System.out.println("Enter the colour for the new piece ");
                    String colour = in.next();
                    Point pos_1 = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    if (split.length == 3) {
                        Piece piece = new SlowPiece(name, colour, pos_1);
                        gameBoard.add(piece);
                    }
                    if (split.length == 4) {
                        if (split[3].equals("fast")) {
                            Piece piece = new FastPiece(name, colour, pos_1);
                            gameBoard.add(piece);
                        }
                        else if (split[3].equals("flexible")) {
                            Piece piece = new SlowFlexible(name, colour, pos_1);
                            gameBoard.add(piece);
                        }
                    }
                    else{
                        Piece piece = new FastFlexible(name, colour, pos_1);
                        gameBoard.add(piece);
                    }
                    System.out.println("Enter a command (type help for details): ");
                }
            }
            if (split[0].equals("move")) {
                pos = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                if (split.length == 4) {
                    gameBoard.move(pos, split[3], 1);
                }
                if (split.length == 5) {
                    gameBoard.move(pos, split[3], Integer.parseInt(split[4]));
                }
                System.out.println("Enter a command (type help for details): ");
            }

            if (split[0].equals("help")) {
                System.out.println("Possible commands are as follows:");
                System.out.println("create location [fast][flexible]: Creates a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece.");
                System.out.println("print: Displays the board.");
                System.out.println("help: Displays help.");
                System.out.println("exit: Exits the program.");
                System.out.println("Enter a command (type help for details): ");
            }
            if (split[0].equals("print")) {
                gameBoard.display();
                System.out.println("Enter a command (type help for details): ");
            }
        }
        System.out.println("Done");
    }
}
