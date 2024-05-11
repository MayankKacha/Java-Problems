package ChessGame;

import java.util.*;

public class Chess extends BoardGame{
    private final ChessPlayer player1, player2;
    public Chess(ChessPlayer player1, ChessPlayer player2, ChessBoard chessBoard) {
        super(chessBoard, new ArrayDeque<Player>(
                Arrays.asList(player1,player2)
        ));
        this.player1 = player1;
        this.player2 = player2;
        prepareBoard(player1,player2,chessBoard);
    }
    @Override
    public boolean isOver() {
        return player1.getPiece(PieceName.KING).isDead() || player2.getPiece(PieceName.KING).isDead();
    }

    private void prepareBoard(ChessPlayer player1 , ChessPlayer player2 , ChessBoard chessBoard){
        placePawns(1,chessBoard,player1);
        placePawns(6,chessBoard,player2);
        placeRooks(0,chessBoard,player1);
        placeRooks(7,chessBoard,player2);
        placeKnights(0,chessBoard,player1);
        placeKnights(7,chessBoard,player2);
        placeBishops(0,chessBoard,player1);
        placeBishops(7,chessBoard,player2);
        placeKing(0,chessBoard,player1);
        placeKing(7,chessBoard,player2);
        placeQueen(0,chessBoard,player1);
        placeQueen(7,chessBoard,player2);
    }

    private void placePawns(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        List<PieceName> pieceNames = Arrays.asList(PieceName.PAWN1, PieceName.PAWN2, PieceName.PAWN3, PieceName.PAWN4 , PieceName.PAWN5, PieceName.PAWN6, PieceName.PAWN7, PieceName.PAWN8);
        int col = 0;
        for (PieceName pieceName : pieceNames){
            chessBoard.putPiece(chessPlayer.getPiece(pieceName) , row, col++);
        }
    }

    private void placeRooks(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.ROOK1) , row, 0);
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.ROOK2) , row, 7);
    }

    private void placeKnights(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.KNIGHT1) , row, 1);
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.KNIGHT2) , row, 6);
    }

    private void placeBishops(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.BISHOP1) , row, 2);
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.BISHOP2) , row, 5);
    }

    private void placeKing(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.KING) , row, 3);
    }

    private void placeQueen(int row, ChessBoard chessBoard , ChessPlayer chessPlayer){
        chessBoard.putPiece(chessPlayer.getPiece(PieceName.QUEEN) , row, 4);
    }

}
