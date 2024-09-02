package de.tidalharvest.game.model.worker.task.reward;

import de.tidalharvest.game.GameCropHolder;
import de.tidalharvest.game.GameHolder;
import de.tidalharvest.game.model.worker.task.TaskQueue;
import de.tidalharvest.game.model.worker.task.farmer.HarvestTask;
import de.tidalharvest.game.model.worker.task.farmer.PlantTask;
import de.tidalharvest.game.model.worker.task.TransportationTask;
import de.tidalharvest.game.model.worker.task.farmer.RepairTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskRewardIssuer {

    private final TaskQueue taskQueue;
    private final GameHolder gameHolder;

    public void reward(TransportationTask task) {

    }

    public void reward(PlantTask farmerTasks) {

    }

    public void reward(HarvestTask harvestTask) {
        taskQueue.schedule(gameHolder.getDefaultGame().getId(),
                new PlantTask(harvestTask.getX(), harvestTask.getY()));

    }

    public void reward(RepairTask repairTask) {

    }
}
