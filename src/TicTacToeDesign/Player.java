package TicTacToeDesign;

import java.util.Scanner;

public class Player implements IPlayer {

    private char symbol;

    Player(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public Move Play(){
        System.out.println("Please enter your move");
        Scanner scanner = new Scanner(System.in);
        String enteredMove = scanner.nextLine();
        String[] splitMoves = enteredMove.split(" ");
        if (splitMoves.length == 2){
            int xMove = Integer.parseInt(splitMoves[0]);
            int yMove = Integer.parseInt(splitMoves[1]);
            return new Move(xMove,yMove);
        }
        else{
            throw new RuntimeException("Move should contain 2 co-ordinates, please retry!");
        }
    }

}
