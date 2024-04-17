package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimension;
    private List<List<Cell>> matrix;

    private Cell cell;


    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            matrix.add(new ArrayList<>());
            for(int j=0; j<dimension; j++){
                matrix.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard(){

        for(int i=0; i<dimension; i++){
            List<Cell> cells = this.matrix.get(i);
            for(Cell cell: cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public Board copy() {
        Board copiedBoard = new Board(this.dimension);
        List<List<Cell>> copiedMatrix = new ArrayList<>();

        // Iterate over each row
        for (int i = 0; i < dimension; i++) {
            List<Cell> row = new ArrayList<>();
            // Iterate over each cell in the row
            for (int j = 0; j < dimension; j++) {
                Cell originalCell = this.matrix.get(i).get(j);
                // Create a new cell with the same state as the original cell
                Cell copiedCell = new Cell(originalCell.getRow(), originalCell.getCol());
                copiedCell.setCellstate(originalCell.getCellstate());
                copiedCell.setPlayer(originalCell.getPlayer()); // Optionally, copy player reference
                row.add(copiedCell);
            }
            copiedMatrix.add(row);
        }

        copiedBoard.setMatrix(copiedMatrix);
        return copiedBoard;

    }
}
