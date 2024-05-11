package TicTacToeDesign;

public class Board {

    private char[][] board;

    Board(){
        this.board = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                this.board[i][j] = '.';
            }
        }
    }

    boolean isFull(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(this.board[i][j] == '.'){
                    return false;
                }
            }
        }
        return true;
    }

    public void applyMove(Move move , IPlayer player){
        if (isSpaceAvailable(move)){
            this.board[move.getX()][move.getY()] = player.getSymbol();
        }
    }

    private boolean isSpaceAvailable(Move move){
        return this.board[move.getX()][move.getY()] == '.';
    }

    boolean hasWinningLine(char symbol){
        return hasDiagonalSameSymbol(symbol) || hasHorizontalSameSymbol(symbol) || hasVerticalSameSymbol(symbol);
    }

    private boolean hasVerticalSameSymbol(char symbol){
        for (int i=0;i<3;i++){
            if (this.board[i][0] == symbol && this.board[i][1] == symbol && this.board[i][2] == symbol)
                return true;
        }
        return false;
    }

    private boolean hasHorizontalSameSymbol(char symbol){
        for (int i=0;i<3;i++){
            if (this.board[0][i] == symbol && this.board[1][i] == symbol && this.board[2][i] == symbol)
                return true;
        }
        return false;
    }

    private boolean hasDiagonalSameSymbol(char symbol){
        boolean leftDiagonal = false;
        boolean rightDiagonal = false;
        leftDiagonal = this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol;
        rightDiagonal = this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol;
        return leftDiagonal || rightDiagonal;
    }
}
