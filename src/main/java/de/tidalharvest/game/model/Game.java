package de.tidalharvest.game.model;

import de.tidalharvest.game.model.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class Game {

    private final long id = UUID.randomUUID().getMostSignificantBits();

    private int timeSinceStart;
    private Board board;
    private boolean paused;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                '}';
    }
}
