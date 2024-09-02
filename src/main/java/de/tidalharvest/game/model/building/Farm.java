package de.tidalharvest.game.model.building;


import de.tidalharvest.game.model.crop.CropType;
import de.tidalharvest.game.model.worker.Farmer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Farm extends AbstractBuilding {

    private CropType cropType = CropType.WHEAT;
    private Integer store;
    private Integer storeMax = 100;

    public Farm(Integer x, Integer y) {
        super(x, y, BuildingType.FARM, 1);
        inhabitants().add(new Farmer(this));
    }
}
