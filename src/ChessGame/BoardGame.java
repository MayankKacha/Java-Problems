package ChessGame;

import java.util.Queue;

// abstract because we can create different instance of this class like chess game and snake and ladder game etx and child classes then will need to implement isOver function
// which will have logic of games in it
// why abstract over interface is startGame is so generic which can be applied to any board games so
public abstract class BoardGame {

    private final IBoard board;
    private final Queue<Player> players;
    public BoardGame(IBoard board, Queue<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void startGame(){

        while (true){
            if (players != null && !players.isEmpty()){
                Player currentPlayer = players.poll();
                Move currentMove = currentPlayer.makeMove();
                board.applyMove(currentMove);
                if (isOver()){
                    System.out.println("Game up.. " + currentPlayer.getName() + " won!");
                    break;
                }
                players.add(currentPlayer);
            }
        }
    }

    public abstract boolean isOver();

}
