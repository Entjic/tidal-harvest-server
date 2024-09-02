package de.tidalharvest.game.model.crop;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Crop {

    private CropType type;
    private boolean grown;
    private double growthProgress; // in [0,1];

}
