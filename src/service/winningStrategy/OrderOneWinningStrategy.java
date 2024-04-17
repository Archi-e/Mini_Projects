package service.winningStrategy;

import model.Board;
import model.Cell;
import model.Move;
import model.Player;

import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    List<HashMap<Character, Integer>> rowHashMapList;
    List<HashMap<Character, Integer>> colHashMapList;
    HashMap<Character, Integer> leftDiag;
    HashMap<Character, Integer> rightDiag;
    HashMap<Character, Integer> cornerMap;

    @Override
    public Player checkWinner(Board board, Move lastMovePlayed) {
        Cell lastMovePlayedCell = lastMovePlayed.getCell();
        int row = lastMovePlayedCell.getRow();
        int col = lastMovePlayedCell.getCol();
        Character symbol = lastMovePlayed.getPlayer().getSymbol();


        return null;
    }

    public Player checkRowForWinner(int row){
        return null;
    }
}
