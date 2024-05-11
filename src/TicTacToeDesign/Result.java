package TicTacToeDesign;

public class Result {

    private boolean isDraw;
    private IPlayer currentPlayer;

    Result(boolean isDraw, IPlayer currentPlayer){
        this.isDraw = isDraw;
        this.currentPlayer = currentPlayer;
    }

    boolean isDraw(){
        return this.isDraw;
    }

    IPlayer currentPlayer(){
        return this.currentPlayer;
    }
}
