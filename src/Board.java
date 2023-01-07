import java.awt.Point;

public class Board {
    public static Piece[][] board;

    public Board() {
        board = new Piece[8][8];
    }

    public String add(Piece p) {
        if (board[p.getPosition().x][p.getPosition().y] != null) {
            return "there is already piece on this position";
        }
        else {
            board[p.getPosition().x][p.getPosition().y] = p;
            return p.toString();
        }
    }

    public void move(Point pt, String direction, int step) {
        if (board[pt.x][pt.y] == null) {
            System.out.println("Error: there is no piece at this location");
        }
        else {
            Piece p1 = board[pt.x][pt.y];
            if (p1 instanceof SlowPiece) {
                if (step > 1) {
                    System.out.println("Error: there is no piece at this location");
                }
                else {
                    board[p1.getPosition().x][p1.getPosition().y] = null;
                    ((SlowFlexible)p1).move(direction);
                    board[p1.getPosition().x][p1.getPosition().y] = p1;
                }
            }
            else {
                board[p1.getPosition().x][p1.getPosition().y] = null;
                ((FastPiece)p1).move(direction, step);
                board[p1.getPosition().x][p1.getPosition().y] = p1;
            }
        }
    }

    public void display() {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                if (board[j][i] == null) {
                    System.out.print("    -    ");
                }
                else {
                    System.out.print(board[j][i]);
                }
            }
            System.out.println();
        }
    }
}