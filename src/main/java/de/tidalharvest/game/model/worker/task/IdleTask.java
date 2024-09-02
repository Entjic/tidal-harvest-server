package de.tidalharvest.game.model.worker.task;

import de.tidalharvest.game.model.worker.Profession;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.task.reward.TaskRewardIssuer;
import de.tidalharvest.game.model.worker.task.work.TaskWorker;

public class IdleTask implements WorkerTask {

    public static IdleTask INSTANCE = new IdleTask();

    @Override
    public boolean matchesProfession(Profession profession) {
        return false;
    }

    @Override
    public Integer getX() {
        throw new IllegalArgumentException();
    }

    @Override
    public Integer getY() {
        throw new IllegalArgumentException();
    }

    @Override
    public double getProgress() {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isDone() {
        throw new IllegalArgumentException();
    }

    @Override
    public void increaseProgress(double progress) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean taken() {
        throw new IllegalArgumentException();
    }

    @Override
    public void take() {
        throw new IllegalArgumentException();
    }

    @Override
    public void free() {
        throw new IllegalArgumentException();
    }

    @Override
    public void done(TaskRewardIssuer issuer) {
        System.out.println("Completed idle task");
    }

    @Override
    public void work(Worker worker, TaskWorker taskWorker) {
        System.out.println("Working on idle task..");
    }
}
