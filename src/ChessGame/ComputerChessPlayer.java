package ChessGame;

import java.util.Map;

public class ComputerChessPlayer extends ChessPlayer{
    public ComputerChessPlayer(String name, Map<PieceName, ChessPiece> pieces, ChessBoard chessBoard) {
        super(name,chessBoard, pieces);
    }

    @Override
    public Move makeMove() {
        return super.makeMove();
    }
}
