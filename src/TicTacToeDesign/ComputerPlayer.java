package TicTacToeDesign;

import java.util.Random;

public class ComputerPlayer implements IPlayer {
    private char symbol;

    public char getSymbol(){
        return this.symbol;
    }

    ComputerPlayer(char symbol){
        this.symbol = symbol;
    }

    public Move Play(){
        Random random = new Random();
        int randomIntX = random.nextInt(3);
        int randomIntY = random.nextInt(3);
        return new Move(randomIntX,randomIntY);
    }

}
