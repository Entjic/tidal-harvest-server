package de.tidalharvest.game.model.worker.task.work;

import de.tidalharvest.game.GameHolder;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.pathfinding.Coordinate;
import de.tidalharvest.game.model.worker.pathfinding.PathFinder;
import de.tidalharvest.game.model.worker.task.TransportationTask;
import de.tidalharvest.game.model.worker.task.WorkerTask;
import de.tidalharvest.game.model.worker.task.farmer.HarvestTask;
import de.tidalharvest.game.model.worker.task.farmer.PlantTask;
import de.tidalharvest.game.model.worker.task.farmer.RepairTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskWorker {

    private final PathFinder pathFinder;
    private final GameHolder holder;

    public void work(Worker worker) {
        // prioritize walking
        if (worker.hasPath()) {
            worker.walk();
            return;
        }

        WorkerTask task = worker.task();
        // we assume this is an adequate task for this specific worker,
        // ie no checking for professions at this point
        task.work(worker, this); // decorator to avoid instanceof calls
    }

    private boolean isWorkerOnTaskTargetField(Worker worker, WorkerTask task) {
        return task.getX() == worker.currentX() && task.getY() == worker.currentY();
    }

    private void executeTask(Worker worker, WorkerTask task) {
        boolean matchesProfession = task.matchesProfession(worker.profession());
        if (matchesProfession) {
            task.increaseProgress(0.2);
            return;
        }
        task.increaseProgress(0.1);
    }

    public void work(HarvestTask harvestTask, Worker worker) {
        walkToTargetOrWork(harvestTask, worker);
    }

    private void schedulePathFinding(Worker worker, WorkerTask task) {
        List<Coordinate> path = pathFinder.findPath(
                new Coordinate(worker.currentX(), worker.currentY()),
                new Coordinate(task.getX(), task.getY()),
                holder.getDefaultGame().getBoard()
        );
        worker.schedulePath(path);
    }

    public void work(PlantTask plantTask, Worker worker) {
        walkToTargetOrWork(plantTask, worker);
    }

    public void work(RepairTask repairTask, Worker worker) {
        // implement later
    }

    private void walkToTargetOrWork(WorkerTask task, Worker worker) {
        if (isWorkerOnTaskTargetField(worker, task)) {
            executeTask(worker, task);
            return;
        }
        schedulePathFinding(worker, task);
        worker.walk();
    }

    public void work(TransportationTask transportationTask, Worker worker) {
        // implement later
    }
}
