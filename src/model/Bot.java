package model;

import service.botPlayingStrategy.BotPlayingStrategy;
import service.botPlayingStrategy.BotPlayingStrategyFactory;
import service.botPlayingStrategy.BotPlayingStrategyName;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, 'B', PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move makeMove(Board board){
        return BotPlayingStrategyFactory.getBotPlayingStrategy(BotPlayingStrategyName.RANDOM).makeMove(board, this);
    }
}
