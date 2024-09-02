package de.tidalharvest.game;

import de.tidalharvest.game.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class GameHolder {

    private final DefaultGameGenerator defaultGameGenerator;
    private final GameCropHolder cropHolder;

    private final Map<Long, Game> games = new HashMap<>();

    private Long defaultGame = -1L;

    public void put(Game game) {
        games.put(game.getId(), game);
        cropHolder.put(game.getId(), new CropHolder());
    }

    public Game get(Long id) {
        return games.get(id);
    }



    public Collection<Game> getAll() {
        return games.values();
    }

    // rather for debugging until proper multiple game support
    public Game getDefaultGame() {
        if (games.isEmpty()) {
            Game game = this.defaultGameGenerator.generateGame();
            this.defaultGame = game.getId();
            put(game);
        }
        return games.get(this.defaultGame);
    }

}
