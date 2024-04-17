package model;

import java.util.List;
import java.util.Scanner;

public class Player {
    int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(){

    }

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println(this.name+ "'s turn to make a move!");

        System.out.println("Enter the row number for target cell");
        int row = sc.nextInt();

        System.out.println("Enter the col number for target cell");
        int col = sc.nextInt();

        Cell playedMoveCell = board.getMatrix().get(row).get(col);

        playedMoveCell.setPlayer(this);
        playedMoveCell.setCellstate(CellState.FILLED);


        return new Move(this, playedMoveCell);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
