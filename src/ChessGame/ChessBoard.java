package ChessGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard implements IBoard{
    private static final int rowCount = 8;
    private static final int colCount = 8;
    private final List<List<ChessCells>> cells;
    public ChessBoard() {
        this.cells = new ArrayList<>();
        for (int i=0;i<rowCount;i++){
            List<ChessCells> chessCells = new ArrayList<>();
            for (int j=0;j<colCount;j++){
                chessCells.add(new ChessCells(i,j));
            }
            this.cells.add(chessCells);
        }
    }

    @Override
    public void applyMove(Move move) {
        ChessCells sourceCell = getChessCells(move.getSource());
        ChessPiece chessPiece = sourceCell.getChessPiece().get();
        chessPiece.move(sourceCell, getChessCells(move.getDestination()), this);
    }

    @Override
    public void display() {
        for (int i=0;i<rowCount;i++){
            for (int j =0 ;j<colCount;j++){
                Pair p = new Pair(i,j);
                Optional<ChessPiece> chessPiece = getChessCells(p).getChessPiece();
                if (chessPiece.isEmpty()){
                    System.out.print("0 | ");
                }else {
                    System.out.print(chessPiece.get().getName() + " | ");
                }
            }
            System.out.println();
        }
    }

    public ChessCells getChessCells(Pair pair){
        return this.cells.get(pair.getX()).get(pair.getY());
    }

    public void putPiece(ChessPiece chessPiece, int row, int col) {
        cells.get(row).get(col).setChessPiece(Optional.of(chessPiece));
    }

    public void removePiece(int row, int col){
        cells.get(row).get(col).setChessPiece(Optional.empty());
    }
}
