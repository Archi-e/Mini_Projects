package model;

import exception.InvalidBoardDimension;
import exception.InvalidBotCountException;
import exception.SymbolNotUniqueException;
import service.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private Player currentPlayer;
    private List<Player> players;
    List<Move> moves;
    private GameStatus gameStatus;
    private List<Board> boardStates;
    private WinningStrategy winningStrategy;

    public static Builder builder(){
        return new Builder();
    }
    public Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        this.board = board;
        this.currentPlayer = null;
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.boardStates = new ArrayList<>();
        this.winningStrategy = winningStrategy;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public static class Builder{
        private int dimension;
        private Board board;
        private List<Player> players;
        private WinningStrategy winningStrategy;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public void validateDimensionOfBoard(){
            if(dimension < 3 || dimension > 10){
                throw new InvalidBoardDimension("Dimension can be from 3 to 10");
            }
        }

        public void validatePlayerSymbol(){
            HashSet<Character> symbol = new HashSet<>();
            for(Player player: players){
                symbol.add(player.getSymbol());
            }
            if(symbol.size() != players.size()) throw new SymbolNotUniqueException("Players should have unique playing symbols!");
        }

        public void validateBotCount(){
            int botCount = 0;
            for(Player player: players){
                if(player.getPlayerType().equals(PlayerType.BOT)) botCount++;
            }

            if(botCount > 1 || botCount < 0) throw new InvalidBotCountException("Bot count can be only be 1 or 0");
        }
        public void validate(){
            validateDimensionOfBoard();
            validatePlayerSymbol();
            validateBotCount();
        }

        public Game build(){
            return new Game(new Board(dimension), players, winningStrategy);
        }
    }
}
