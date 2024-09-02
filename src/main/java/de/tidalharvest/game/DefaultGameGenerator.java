package de.tidalharvest.game;

import de.tidalharvest.game.map.BoardGenerator;
import de.tidalharvest.game.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultGameGenerator {

    private final static int DEFAULT_X_SIZE = 20;
    private final static int DEFAULT_Y_SIZE = 20;

    private static final double DEFAULT_ROCK_PARAM = 0.2;


    private final BoardGenerator boardGenerator;

    public Game generateGame() {
        Game game = new Game();
        game.setBoard(boardGenerator.generateBoard(DEFAULT_X_SIZE, DEFAULT_Y_SIZE, DEFAULT_ROCK_PARAM));

        return game;
    }

}
