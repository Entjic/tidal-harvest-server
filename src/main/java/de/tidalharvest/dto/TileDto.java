package de.tidalharvest.dto;

import de.tidalharvest.game.model.board.FieldType;
import de.tidalharvest.game.model.building.BuildingType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TileDto {

    private int x, y;
    private FieldType fieldType;
    private BuildingType buildingType;


}
