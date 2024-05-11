package ChessGame;

public class Queen implements ChessPiece{
    private final Color color;
    private final PieceName name;
    private  boolean isDead;

    public Queen(PieceName name,Color color, boolean isDead) {
        this.color = color;
        this.name = name;
        this.isDead = isDead;
    }
    @Override
    public void move(ChessCells source, ChessCells destination, ChessBoard chessBoard) {

    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void setDead(boolean isDead) {

    }

    @Override
    public Color getColor() {
        return this.color;
    }
    @Override
    public PieceName getName() {
        return this.name;
    }
}
