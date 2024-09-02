package de.tidalharvest.game.model.building;

import de.tidalharvest.game.model.crop.CropType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Silo extends AbstractBuilding{

    private CropType cropType;
    private Integer store;
    private Integer storeMax;


    public Silo(Integer x, Integer y) {
        super(x, y, BuildingType.SILO, 0);
    }
}
