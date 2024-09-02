package de.tidalharvest.game.step;

import de.tidalharvest.game.model.Game;

public interface Step {

    void modify(Game game);

    /**
     * Represents the priority of the GameObject, lower numbers get executed first
     * @return int
     */
    int order();

    default void log(Game game){
        System.out.println("Executing step " + getClass().getSimpleName() + " for game " + game);
    }

}
