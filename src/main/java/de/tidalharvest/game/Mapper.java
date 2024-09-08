package de.tidalharvest.game;

import de.tidalharvest.dto.GameStateDto;
import de.tidalharvest.dto.TileDto;
import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.building.BuildingType;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public GameStateDto map(Board board) {
        GameStateDto gameStateDto = new GameStateDto();
        gameStateDto.setX(board.getXSize());
        gameStateDto.setY(board.getYSize());

        for (Field[] row : board.getMatrix()) {
            for (Field field : row) {
                BuildingType type = field.getBuilding() != null ? field.getBuilding().type() : null;
                TileDto tileDto = new TileDto(field.getX(), field.getY(), field.getFieldType().ordinal(), type);
                gameStateDto.getTiles().add(tileDto);
            }
        }
        return gameStateDto;
    }

}
