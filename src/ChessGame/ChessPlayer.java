package ChessGame;

import java.util.Map;

public abstract class ChessPlayer extends Player{
    private final ChessBoard chessBoard;

    private final Map<PieceName,ChessPiece> pieces;
    public ChessPlayer(String name, ChessBoard chessBoard, Map<PieceName, ChessPiece> pieces) {
        super(name);
        this.chessBoard = chessBoard;
        this.pieces = pieces;
    }

    public ChessPiece getPiece(PieceName pieceName){
        if (!pieces.containsKey(pieceName)){
            throw new IllegalArgumentException("Invalid args!");
        }
        return this.pieces.get(pieceName);
    }

    @Override
    public Move makeMove() {
        return null;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public Map<PieceName, ChessPiece> getPieces() {
        return pieces;
    }
}
