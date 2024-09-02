package de.tidalharvest.game.step;

import de.tidalharvest.game.GameHolder;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.model.building.Building;
import de.tidalharvest.game.model.worker.Worker;
import de.tidalharvest.game.model.worker.task.IdleTask;
import de.tidalharvest.game.model.worker.task.TaskQueue;
import de.tidalharvest.game.model.worker.task.WorkerTask;
import de.tidalharvest.game.model.worker.task.reward.TaskRewardIssuer;
import de.tidalharvest.game.model.worker.task.work.TaskWorker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class WorkerStep implements Step {

    private final TaskQueue taskQueue;
    private final TaskRewardIssuer taskRewardIssuer;
    private final TaskWorker taskWorker;
    private final GameHolder gameHolder;

    @Override
    public void modify(Game game) {

        Set<Worker> workers = this.workers(game);
        // this doesn't really have
        // to be recalculated ever single tick
        for (Worker worker : workers) {
            this.work(worker);
        }
    }

    private Set<Worker> workers(Game game) {
        Set<Worker> workers = new HashSet<>();
        for (Field[] matrix : game.getBoard().getMatrix()) {
            for (Field field : matrix) {
                if (field.getBuilding() != null) {
                    Building building = field.getBuilding();
                    for (Worker inhabitant : building.inhabitants()) {
                        if (!inhabitant.idle()) workers.add(inhabitant);
                    }
                }
            }
        }
        return workers;
    }

    private void work(Worker inhabitant) {
        WorkerTask task = taskQueue.getNext(gameHolder.getDefaultGame().getId(), inhabitant);
        if (task instanceof IdleTask) {
            System.out.println("Idling worker " + inhabitant);
            return;
        }


        taskWorker.work(inhabitant);

        if (task.isDone()) {
            task.done(this.taskRewardIssuer);
            return;
        }

        taskQueue.schedule(gameHolder.getDefaultGame().getId(), task);

    }


    @Override
    public int order() {
        return 3;
    }
}
