package de.tidalharvest.game.model.worker.task;

import de.tidalharvest.game.model.worker.Worker;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskQueue {

    private final Map<Long, List<WorkerTask>> tasks = new HashMap<>();

    public WorkerTask getNext(Long id, Worker worker) {
        if (!tasks.containsKey(id)) tasks.put(id, new ArrayList<>());

        for (WorkerTask task : tasks.get(id)) {
            if (task.taken()) continue;
            if (!task.matchesProfession(worker.profession())) continue;
            task.take();
            return task;
        }
        return new IdleTask();
    }

    public void schedule(Long id, WorkerTask task) {
        if (!tasks.containsKey(id)) tasks.put(id, new ArrayList<>());
        tasks.get(id).add(task);
    }


}
