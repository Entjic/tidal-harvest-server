package de.tidalharvest.game.model.worker.task.farmer;

import de.tidalharvest.game.model.worker.FarmerTasks;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.task.reward.TaskRewardIssuer;
import de.tidalharvest.game.model.worker.task.work.TaskWorker;

public class HarvestTask extends FarmerTask {
    public HarvestTask(Integer x, Integer y) {
        super(x, y, FarmerTasks.HARVESTING);
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
