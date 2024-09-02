package de.tidalharvest.game.model.worker.task;

import de.tidalharvest.game.model.worker.Profession;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class AbstractWorkerTask implements WorkerTask {

    private final Profession profession;
    private final Integer x, y;
    private double progress; // in [0,1]

    private boolean taken; // scheduling relevant

    @Override
    public boolean matchesProfession(Profession profession) {
        if (this.profession.equals(Profession.WILDCARD)) return true;
        return this.profession.equals(profession);
    }

    @Override
    public Integer getX() {
        return this.x;
    }

    @Override
    public Integer getY() {
        return this.y;
    }

    @Override
    public double getProgress() {
        return this.progress;
    }

    @Override
    public boolean isDone() {
        return this.progress >= 1.0;
    }

    @Override
    public void increaseProgress(double progress) {
        this.progress += progress;
    }

    @Override
    public void take() {
        this.taken = true;
    }

    @Override
    public boolean taken() {
        return this.taken;
    }

    @Override
    public void free() {
        this.taken = false;
    }

}
