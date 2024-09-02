package de.tidalharvest.game.model.board;


import de.tidalharvest.game.model.building.Building;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Field {
    // rename to tile?
    private int x;
    private int y;

    private boolean flooded;
    private FieldType fieldType = FieldType.ROCK;
    private double humidity = 0.5; // in [0; 1]
    private Building building;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return x == field.x && y == field.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
