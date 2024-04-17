import controller.GameController;
import model.*;
import service.botPlayingStrategy.BotPlayingStrategyFactory;
import service.botPlayingStrategy.BotPlayingStrategyName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();

        System.out.println("Hey you, Welcome to TicTacToe2.0!");
        System.out.println("You can any choose the dimension for the Game Board(3-10)");
        int id = 1;

        System.out.println("Enter the dimension of the Game Board: ");
        int dimension = sc.nextInt();

        System.out.println("Do you want a BOT as one of the players? Y / N");
        String botAnswer = sc.next();

        System.out.println("Enter Bot Difficulty Level: EASY/MEDIUM/HARD");
        String diffAnswer = sc.next();

        if(botAnswer.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++, "TIC TAC",BotDifficultyLevel.HARD);
            players.add(bot);
        }

        System.out.println("Enter the number of players: ");
        int n = sc.nextInt();



    }
}
