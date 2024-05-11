package TicTacToeDesign;

public class TicTacToe {

    private IPlayer player1;

    private IPlayer player2;

    private Board board;

    TicTacToe(IPlayer player1 , IPlayer player2 , Board board){
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }

    public Result GameStart(){
        IPlayer currentPlayer = this.player1;
        while (!this.board.isFull()){
            Move currentMove = currentPlayer.Play();
            this.board.applyMove(currentMove, currentPlayer);
            if (this.board.hasWinningLine(currentPlayer.getSymbol())){
                return new Result(false , currentPlayer);
            }
            if (currentPlayer == this.player1) currentPlayer = this.player2;
            else currentPlayer = this.player1;
        }
        return new Result(true,currentPlayer);
    }
}
