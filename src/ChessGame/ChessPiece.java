package ChessGame;

public interface ChessPiece {

    void move(ChessCells source, ChessCells destination, ChessBoard chessBoard);

    boolean isDead();

    void setDead(boolean isDead);

    PieceName getName();

    Color getColor();

}
