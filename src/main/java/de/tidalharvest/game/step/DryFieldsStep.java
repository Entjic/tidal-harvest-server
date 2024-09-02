package de.tidalharvest.game.step;

import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.Game;
import org.springframework.stereotype.Component;

@Component
public class DryFieldsStep implements Step {
    @Override
    public void modify(Game game) {
        for (int x = 0; x < game.getBoard().getXSize(); x++) {
            for (int y = 0; y < game.getBoard().getYSize(); y++) {
                Field field = game.getBoard().getMatrix()[x][y];
                field.setHumidity(calcHumidity(x, y, field.getHumidity()));
            }
        }
    }

    private double calcHumidity(int x, int y, double current){
        if(y <= 5) return current;
        return current * 0.99;
    }

    @Override
    public int order() {
        return 9;
    }
}
