package de.tidalharvest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceActionDto {

    private Integer buildingType;
    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return "PlaceActionDto{" +
                "fieldType='" + buildingType + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
