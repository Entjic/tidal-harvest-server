package de.tidalharvest.game.model.worker.task.farmer;

import de.tidalharvest.game.model.worker.FarmerTasks;
import de.tidalharvest.game.model.worker.Profession;
import de.tidalharvest.game.model.worker.task.AbstractWorkerTask;
import lombok.Getter;

@Getter
public abstract class FarmerTask extends AbstractWorkerTask {

    private final FarmerTasks type;

    public FarmerTask(Integer x, Integer y, FarmerTasks type) {
        super(Profession.FARMER, x, y);
        this.type = type;
    }

}
