package de.tidalharvest.game.model.building;

import de.tidalharvest.game.model.worker.Worker;

import java.util.Set;

public interface Building {
    
    Integer maxInhabitants();
    Set<Worker> inhabitants();

    Integer x();
    Integer y();

    BuildingType type();
    
}
