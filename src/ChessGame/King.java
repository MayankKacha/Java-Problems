package ChessGame;

public class King implements ChessPiece{

    private final Color color;
    private final PieceName name;
    private  boolean isDead;

    public King(PieceName name,Color color, boolean isDead) {
        this.color = color;
        this.name = name;
        this.isDead = isDead;
    }
    @Override
    public void move(ChessCells source, ChessCells destination, ChessBoard chessBoard) {

    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public PieceName getName() {
        return this.name;
    }
}
