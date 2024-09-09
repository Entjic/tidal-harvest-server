package de.tidalharvest.game.model.building;

public enum BuildingType {
    FARM,
    BARRACK,
    SILO;

    public static BuildingType fromId(Integer id) {
        if (id == null) {
            return null;
        }
        for (BuildingType buildingType : BuildingType.values()) {
            System.out.println("Building type: " + buildingType.name() + " has ordinal: " + buildingType.ordinal());
            if (buildingType.ordinal() == id) {
                return buildingType;
            }
        }
        return null;
    }

}
