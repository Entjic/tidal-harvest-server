package de.tidalharvest.game.model.worker;


import de.tidalharvest.game.model.building.Building;
import de.tidalharvest.game.model.worker.pathfinding.Coordinate;
import de.tidalharvest.game.model.worker.task.IdleTask;
import de.tidalharvest.game.model.worker.task.WorkerTask;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractWorker implements Worker {

    private final Profession profession;
    private final Building home;
    private int currentX, currentY;
    private boolean outside;

    private List<Coordinate> path;

    private WorkerTask task;

    @Override
    public Profession profession() {
        return this.profession;
    }

    @Override
    public Building home() {
        return this.home;
    }

    @Override
    public int currentX() {
        return this.currentX;
    }

    @Override
    public int currentY() {
        return this.currentY;
    }

    @Override
    public void currentX(Integer x) {
        this.currentX = x;
    }

    @Override
    public void currentY(Integer y) {
        this.currentY = y;
    }

    @Override
    public boolean outside() {
        return this.outside;
    }

    @Override
    public void outside(boolean outside) {
        this.outside = outside;
    }

    @Override
    public WorkerTask task() {
        return this.task;
    }

    @Override
    public void scheduleTask(WorkerTask task) {
        if (task != null) this.task = task;
    }

    @Override
    public void clearTask() {
        this.task = IdleTask.INSTANCE;
    }

    @Override
    public void schedulePath(List<Coordinate> path) {
        this.path = path;
    }

    @Override
    public void walk() {
        Coordinate first = this.path.getFirst();
        this.currentX(first.x());
        this.currentY(first.y());
        this.path.removeFirst();
    }
}
