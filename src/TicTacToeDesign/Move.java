package TicTacToeDesign;

public class Move {

    private int x;
    private int y;

    Move(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

}
