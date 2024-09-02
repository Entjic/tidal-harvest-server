package de.tidalharvest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceCropTypedActionDto {

    private Integer buildingType;
    private String crop;
    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return "PlaceFarmerActionDto{" +
                "fieldType=" + buildingType +
                ", crop='" + crop + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
