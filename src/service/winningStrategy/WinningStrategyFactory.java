package service.winningStrategy;

import static service.winningStrategy.WinningStrategyName.ORDERONE;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyName winningStrategyName, int dimension){
        switch(winningStrategyName){
            case ORDERONE : return new OrderOneWinningStrategy(dimension);
        }
        return null;
    }
}
