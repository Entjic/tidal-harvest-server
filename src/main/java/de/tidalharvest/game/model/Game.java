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

    private final Long id = UUID.randomUUID().getMostSignificantBits();

    private Integer timeSinceStart;
    private Board board;
    private Boolean paused;
}
