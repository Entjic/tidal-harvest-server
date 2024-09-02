package de.tidalharvest.game.model.crop;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CropType {

    WHEAT("Weizen"),
    MELON("Melonen"),
    CORN("Mais");

    private final String key;

    public static CropType fromKey(String key) {
        for (CropType cropType : CropType.values()) {
            if (cropType.key.equals(key)) {
                return cropType;
            }
        }
        return null;
    }

}
