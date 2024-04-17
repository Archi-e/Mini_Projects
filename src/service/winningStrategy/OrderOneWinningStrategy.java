package service.winningStrategy;

import model.Board;
import model.Cell;
import model.Move;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    private int dimension;
    List<HashMap<Character, Integer>> rowHashMapList;
    List<HashMap<Character, Integer>> colHashMapList;
    HashMap<Character, Integer> leftDiag;
    HashMap<Character, Integer> rightDiag;
    HashMap<Character, Integer> cornerMap;

    public OrderOneWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowHashMapList = new ArrayList<>();
        this.colHashMapList = new ArrayList<>();
        this.leftDiag = new HashMap<>();
        this.rightDiag = new HashMap<>();
        this.cornerMap = new HashMap<>();

        for(int i=0; i<dimension; i++){
            rowHashMapList.add(new HashMap<>());
            colHashMapList.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMovePlayed) {
        Cell lastMovePlayedCell = lastMovePlayed.getCell();
        int row = lastMovePlayedCell.getRow();
        int col = lastMovePlayedCell.getCol();

        Character symbol = lastMovePlayed.getPlayer().getSymbol();
        Player player = lastMovePlayed.getPlayer();

        boolean winnerResult = (checkRowForWinner(row, symbol)
                                ||checkColForWinner(col, symbol)
                                ||(isCornerCell(row, col) && checkCornersForWinner(symbol))
                                ||(isPartOfLeftDiag(row, col) && checkLeftDiagForWinner(symbol))
                                ||(isPartOfRightDiag(row, col) && checkRightDiagForWinner(symbol)));
        return null;
    }

    public boolean isPartOfLeftDiag(int row, int col){
        return row == col;
    }
    public boolean isPartOfRightDiag(int row, int col){
        return ((row+col) == (dimension-1));
    }

    public boolean isCornerCell(int row, int col){
        return (
                (row == 0 && col ==0)
                || (row == 0 && col == dimension-1)
                || (row == dimension-1 && col == 0)
                || (row == dimension-1 && col == dimension-1)
        );
    }


    public boolean checkRowForWinner(int row, Character symbol){
        HashMap<Character, Integer> currentRowMap = rowHashMapList.get(row);
        if(currentRowMap.containsKey(symbol)){
            currentRowMap.put(symbol, currentRowMap.get(symbol)+1);
            return (currentRowMap.get(symbol) == dimension);
        }
        else{
            currentRowMap.put(symbol, 1);
        }
        return false;
    }

    public boolean checkColForWinner(int col, Character symbol){
        HashMap<Character, Integer> currentColMap = colHashMapList.get(col);
        if(currentColMap.containsKey(symbol)){
            currentColMap.put(symbol, currentColMap.get(symbol)+1);
            return (currentColMap.get(symbol) == dimension);
        }
        else{
            currentColMap.put(symbol, 1);
        }
        return false;
    }

    public boolean checkLeftDiagForWinner(Character symbol){
        if(leftDiag.containsKey(symbol)){
            leftDiag.put(symbol, leftDiag.get(symbol)+1);
            return (leftDiag.get(symbol) == dimension);
        }
        else{
            leftDiag.put(symbol, 1);
        }
        return false;
    }

    public boolean checkRightDiagForWinner(Character symbol){
        if(rightDiag.containsKey(symbol)){
            rightDiag.put(symbol, rightDiag.get(symbol)+1);
            return (rightDiag.get(symbol) == dimension);
        }
        else{
            rightDiag.put(symbol, 1);
        }
        return false;
    }

    public boolean checkCornersForWinner(Character symbol){
        if(cornerMap.containsKey(symbol)){
            cornerMap.put(symbol, cornerMap.get(symbol)+1);
            return (cornerMap.get(symbol) == 4);
        }
        else{
            cornerMap.put(symbol, 1);
        }
        return false;
    }






}
