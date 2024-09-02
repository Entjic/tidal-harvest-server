package de.tidalharvest.game.step;

import de.tidalharvest.game.CropHolder;
import de.tidalharvest.game.GameCropHolder;
import de.tidalharvest.game.GameHolder;
import de.tidalharvest.game.model.crop.Crop;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.model.worker.FarmerTasks;
import de.tidalharvest.game.model.worker.task.farmer.FarmerTask;
import de.tidalharvest.game.model.worker.task.TaskQueue;
import de.tidalharvest.game.model.worker.task.farmer.HarvestTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class GrowCropsStep implements Step {

    private final GameCropHolder gameCropHolder;
    private final TaskQueue taskQueue;
    private final GameHolder gameHolder;

    @Override
    public void modify(Game game) {
        CropHolder cropHolder = gameCropHolder.get(game.getId());
        for (Map.Entry<Field, Crop> entry : cropHolder.entries()) {
            Field field = entry.getKey();
            Crop crop = entry.getValue();
            if (crop.isGrown()) continue;
            grow(field, crop);
        }
    }

    private void grow(Field field, Crop crop) {
        double next = Double.max(1, crop.getGrowthProgress() + (field.getHumidity() * 0.1));
        crop.setGrowthProgress(next);

        if (next == 1.0) {
            crop.setGrown(true);
            taskQueue.schedule(gameHolder.getDefaultGame().getId(),
                    new HarvestTask(field.getX(), field.getY()));
        }
    }

    @Override
    public int order() {
        return 0;
    }
}
