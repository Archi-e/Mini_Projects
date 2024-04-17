package controller;

import model.*;
import service.winningStrategy.WinningStrategyFactory;
import service.winningStrategy.WinningStrategyName;

import java.util.List;

import static java.lang.Thread.sleep;

public class GameController {
    public Game createGame(int dimension, List<Player> players, WinningStrategyName winningStrategyName){
        return new Game.Builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(winningStrategyName, dimension))
                .build();
    }

    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getBoard());
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void UndoMove(Game game){
        List<Board> boardStates = game.getBoardStates();
        List<Move> moves = game.getMoves();
        boardStates.remove(boardStates.size()-1);
        moves.remove(moves.size()-1);
        game.getBoard().displayBoard();
    }

    public Player checkWinner(Game game, Move lastMovePlayed){
       return game.getWinningStrategy().checkWinner(game.getBoard(), lastMovePlayed);
    }

    public void replay(Game game) throws InterruptedException {
        int i=0;
        int count = 1;
        List<Move> moves = game.getMoves();
        for(Board board: game.getBoardStates()){
            System.out.println("Move "+ count++ +" Played by "+ moves.get(i++).getPlayer().getName());
            board.displayBoard();
            System.out.println();
            Thread.sleep(3000);
        }
    }
}
