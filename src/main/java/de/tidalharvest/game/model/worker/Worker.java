package de.tidalharvest.game.model.worker;


import de.tidalharvest.game.model.building.Building;
import de.tidalharvest.game.model.worker.pathfinding.Coordinate;
import de.tidalharvest.game.model.worker.task.IdleTask;
import de.tidalharvest.game.model.worker.task.WorkerTask;

import java.util.List;

public interface Worker {

    Building home();

    int currentX();

    int currentY();

    void currentX(Integer x);

    void currentY(Integer y);

    boolean outside();

    void outside(boolean b);

    Profession profession();

    WorkerTask task();

    void scheduleTask(WorkerTask task);

    default boolean idle() {
        return task() != null && !(task() instanceof IdleTask);
    }

    void clearTask();

    void schedulePath(List<Coordinate> path);

    boolean hasPath();

    void walk();

}
