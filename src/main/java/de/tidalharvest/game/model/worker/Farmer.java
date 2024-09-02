package de.tidalharvest.game.model.worker;


import de.tidalharvest.game.model.building.Building;

public class Farmer extends AbstractWorker {

    public Farmer(Building home) {
        super(Profession.FARMER, home);
    }


}
