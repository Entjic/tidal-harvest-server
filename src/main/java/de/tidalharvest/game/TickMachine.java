package de.tidalharvest.game;

import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.step.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class TickMachine {

    private final GameHolder gameHolder;

    private final FloodStep floodStep;
    private final GrowCropsStep growCropsStep;
    private final WorkerStep workerStep;
    private final DryFieldsStep dryFieldsStep;
    private final TimeStep timeStep;


    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void tick() {
        for (Game game : gameHolder.getAll()) {
            if (game.getPaused()) {
                System.out.println("not ticking paused game" + game.getId());
                continue;
            }
            long before = System.currentTimeMillis();
            tick(game);
            long after = System.currentTimeMillis();
            System.out.println("Ticking game " + game.getId() + " took " + (after - before) + " milliseconds, if > 1000ms game is lagging");
        }
    }

    private void tick(Game game) {
        Iterator<Step> steps = steps();

        while (steps.hasNext()) {
            Step step = steps.next();
            step.log(game);
            step.modify(game);
        }

    }

    private Iterator<Step> steps() {
        List<Step> steps = new ArrayList<>();
        steps.add(floodStep);
        steps.add(growCropsStep);
        steps.add(workerStep);
        steps.add(dryFieldsStep);
        steps.add(timeStep);

        steps.sort(Comparator.comparingInt(Step::order));

        return steps.iterator();
    }

}
