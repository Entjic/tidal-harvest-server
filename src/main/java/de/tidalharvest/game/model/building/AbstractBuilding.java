package de.tidalharvest.game.model.building;


import de.tidalharvest.game.model.worker.Worker;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public abstract class AbstractBuilding implements Building {

    private final Integer x, y;
    private final BuildingType type;
    private final Integer maxInhabitants;
    private final Set<Worker> inhabitants = new HashSet<>();

    @Override
    public Integer x() {
        return this.x;
    }

    @Override
    public Integer y() {
        return this.y;
    }

    @Override
    public BuildingType type() {
        return this.type;
    }

    @Override
    public Integer maxInhabitants() {
        return this.maxInhabitants;
    }

    @Override
    public Set<Worker> inhabitants() {
        return inhabitants;
    }
}
