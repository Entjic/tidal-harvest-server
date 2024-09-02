package de.tidalharvest.game.step;

import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.Game;
import org.springframework.stereotype.Component;

@Component
public class FloodStep implements Step {

    private int ticksSinceFlood = 0;

    @Override
    public void modify(Game game) {
        if (ticksSinceFlood++ % 10 == 0) {
            ticksSinceFlood = 0;
            System.out.println("triggering flood");
            flood(game);
        }
    }

    private void flood(Game game) {
        Board board = game.getBoard();
        for (Field[] row : board.getMatrix()) {
            for (Field field : row) {
                field.setHumidity(1.0);
            }
        }
    }

    @Override
    public int order() {
        return 10;
    }
}
