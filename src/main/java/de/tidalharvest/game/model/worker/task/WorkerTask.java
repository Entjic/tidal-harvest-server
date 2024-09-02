package de.tidalharvest.game.model.worker.task;

import de.tidalharvest.game.model.worker.Profession;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.task.reward.TaskRewardIssuer;
import de.tidalharvest.game.model.worker.task.work.TaskWorker;

public interface WorkerTask {
    boolean matchesProfession(Profession profession);

    Integer getX();

    Integer getY();

    double getProgress();

    boolean isDone();

    void increaseProgress(double progress);

    boolean taken();

    void take();

    void free();

    void done(TaskRewardIssuer issuer);

    void work(Worker worker, TaskWorker taskWorker);
}
