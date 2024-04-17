import controller.GameController;
import model.*;
import service.botPlayingStrategy.BotPlayingStrategyFactory;
import service.botPlayingStrategy.BotPlayingStrategyName;
import service.winningStrategy.WinningStrategyName;

import java.util.*;

public class TicTacToe {
    public static void main(String[] args) throws InterruptedException {
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

        while(id < dimension){
            System.out.println("Please enter Player Name:");
            String playerName = sc.next();
            System.out.println("Please enter Player Symbol:");
            char playerSymbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++, playerName, playerSymbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        //List<Board> boardStates = new ArrayList<>();
        Collections.shuffle(players);
        Game game = gameController.createGame(dimension, players, WinningStrategyName.ORDERONE);
        int playerIndex = -1;
        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("Current Board Status:");
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();

            Move moveplayed = gameController.executeMove(game, players.get(playerIndex));
            game.getMoves().add(moveplayed);
            game.getBoardStates().add(game.getBoard().copy());
            Player winner = gameController.checkWinner(game, moveplayed);
            if(winner != null){
                System.out.println("##### WINNER IS: "+winner.getName()+" #####");
                break;
            }
            if((game.getMoves().size()) == (game.getBoard().getDimension() * game.getBoard().getDimension())){
                System.out.println("Pssssst... Game DRAW!");
                break;
            }

        }
        //game.setBoardStates(boardStates);
        System.out.println("Final Board Status");
        gameController.displayBoard(game);
        System.out.println("Do you want to see the replay? Y / N");
        String replayAns = sc.next();
        if(replayAns.equalsIgnoreCase("Y")){
            gameController.replay(game);
        }

    }
}
