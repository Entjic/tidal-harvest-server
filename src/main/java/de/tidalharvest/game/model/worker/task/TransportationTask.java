package de.tidalharvest.game.model.worker.task;

import de.tidalharvest.game.model.crop.CropType;
import de.tidalharvest.game.model.worker.Profession;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.task.reward.TaskRewardIssuer;
import de.tidalharvest.game.model.worker.task.work.TaskWorker;
import lombok.Getter;


@Getter
public class TransportationTask extends AbstractWorkerTask {

    private final CropType cropType;
    private final Integer xTo, yTo;

    public TransportationTask(Integer x,
                              Integer y,
                              CropType cropType,
                              Integer xTo,
                              Integer yTo) {
        super(Profession.FARMER, x, y);
        this.cropType = cropType;
        this.xTo = xTo;
        this.yTo = yTo;
    }

    @Override
    public void done(TaskRewardIssuer issuer) {
        issuer.reward(this);
    }

    @Override
    public void work(Worker worker, TaskWorker taskWorker) {
        taskWorker.work(this, worker);
    }
}
