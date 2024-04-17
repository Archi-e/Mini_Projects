package model;

import service.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, BotDifficultyLevel botDifficultyLevel) {
        super(id, name, 'B', PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
