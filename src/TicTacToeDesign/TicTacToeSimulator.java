package TicTacToeDesign;

public class TicTacToeSimulator {

    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe(new ComputerPlayer('X'), new ComputerPlayer('O'), new Board());
        Result result = ticTacToe.GameStart();
        if (result.isDraw()){
            System.out.println("Its Draw!");
        }
        else{
            System.out.println("Player " + result.currentPlayer().getSymbol() + " Won!");
        }
    }

}
