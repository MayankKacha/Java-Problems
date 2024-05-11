package ChessGame;

public class Pawn implements ChessPiece{
    private final Color color;
    private final PieceName name;
    private  boolean isDead;

    public Pawn(PieceName name,Color color, boolean isDead) {
        this.color = color;
        this.name = name;
        this.isDead = isDead;
    }
    @Override
    public void move(ChessCells source, ChessCells destination, ChessBoard chessBoard) {

    }
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }

    @Override
    public PieceName getName() {
        return this.name;
    }
}
