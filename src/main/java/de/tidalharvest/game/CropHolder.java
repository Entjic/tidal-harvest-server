package de.tidalharvest.game;

import de.tidalharvest.game.model.crop.Crop;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.board.FieldType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CropHolder {

    private final Map<Field, Crop> crops = new HashMap<>();

    public void plant(Field field, Crop crop) {
        if (!field.getFieldType().equals(FieldType.FARMLAND)) throw new IllegalArgumentException();
        crops.put(field, crop);
    }

    public void destroy(Field field) {
        crops.remove(field);
    }

    public Crop harvest(Field field) {
        if (!field.getFieldType().equals(FieldType.FARMLAND)) throw new IllegalArgumentException();
        Crop crop = crops.get(field);
        if (crop == null) throw new IllegalArgumentException();
        return crop;
    }

    public Set<Map.Entry<Field, Crop>> entries() {
        return crops.entrySet();
    }


}
