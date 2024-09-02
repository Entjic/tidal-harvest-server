package de.tidalharvest.game;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameCropHolder {

    private final Map<Long, CropHolder> cropHolders = new HashMap<>();

    public void put(final long gameId, final CropHolder cropHolder) {
        cropHolders.put(gameId, cropHolder);
    }

    public void delete(final long gameId) {
        cropHolders.remove(gameId);
    }

    public CropHolder get(final long gameId) {
        return cropHolders.get(gameId);
    }
}
