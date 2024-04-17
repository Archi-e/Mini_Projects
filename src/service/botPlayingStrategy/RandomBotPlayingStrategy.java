package service.botPlayingStrategy;

import exception.GameOverException;
import model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {

        for(int i=0; i< board.getDimension(); i++){
            for (int j=0; j< board.getDimension(); j++){
                Cell cell = board.getMatrix().get(i).get(j);
                if(cell.getCellstate().equals(CellState.EMPTY)){
                    cell.setPlayer(bot);
                    cell.setCellstate(CellState.FILLED);
                    return new Move(bot,cell);
                }
            }
        }
        throw new GameOverException("No empty cell available, it's a draw!");

    }
}
