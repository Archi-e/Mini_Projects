package service.botPlayingStrategy;

import static service.botPlayingStrategy.BotPlayingStrategyName.RANDOM;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotPlayingStrategyName botPlayingStrategyName){
        switch(botPlayingStrategyName){
            case RANDOM : return new RandomBotPlayingStrategy();
        }
        return null;
    }
}
