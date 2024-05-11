package ChessGame;

public class Knight implements ChessPiece{

    private final Color color;
    private final PieceName name;
    private  boolean isDead;

    public Knight(PieceName name,Color color, boolean isDead) {
        this.color = color;
        this.name = name;
        this.isDead = isDead;
    }

    @Override
    public void move(ChessCells source, ChessCells destination, ChessBoard chessBoard) {
        int x_diff = Math.abs(source.getX() - destination.getX());
        int y_diff = Math.abs(source.getY() - destination.getY());

        if (!(Math.max(x_diff,y_diff) == 2 && Math.min(x_diff,y_diff) == 1)){
            throw new RuntimeException("Invalid move!");
        }

        if (destination.getChessPiece().isPresent()){
            if (destination.getChessPiece().get().getColor().equals(this.color)){
                throw new RuntimeException("Same teams piece at that place!");
            }else{
                destination.getChessPiece().get().setDead(true);
            }
        }

        chessBoard.removePiece(source.getX(),source.getY());
        chessBoard.putPiece(this, destination.getX() , destination.getY());

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
    public PieceName getName() {
        return this.name;
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
