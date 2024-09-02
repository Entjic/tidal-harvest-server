package de.tidalharvest.game.step;

import de.tidalharvest.game.model.Game;
import org.springframework.stereotype.Component;

@Component
public class TimeStep implements Step {
    @Override
    public void modify(Game game) {
        game.setTimeSinceStart(game.getTimeSinceStart() + 1);
    }

    @Override
    public int order() {
        return 5;
    }
}
