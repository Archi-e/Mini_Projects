package model;

import service.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(BotDifficultyLevel botDifficultyLevel) {
        super("BOT", 'B', PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;

    }
}
