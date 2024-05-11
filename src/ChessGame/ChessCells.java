package ChessGame;

import java.util.Optional;

public class ChessCells {

    private final int x;
    private final int y;

    private Optional<ChessPiece> chessPiece; // as the pieces at one place can change during game so finally not a good option
    // optional in above is good as not all the cells will have pieces and also it provides some methods to check if its empty or anything
    public ChessCells(int x, int y) {
        this.x = x;
        this.y = y;
        chessPiece = Optional.empty();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Optional<ChessPiece> getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(Optional<ChessPiece> chessPiece) {
        this.chessPiece = chessPiece;
    }

}
