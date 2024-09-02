package de.tidalharvest.controller;

import de.tidalharvest.dto.GameStateDto;
import de.tidalharvest.dto.PlaceActionDto;
import de.tidalharvest.dto.PlaceCropTypedActionDto;
import de.tidalharvest.dto.TileDto;
import de.tidalharvest.game.GameHolder;
import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.building.BuildingType;
import de.tidalharvest.service.PlayerActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/game/action/")
@RequiredArgsConstructor
public class PlayerActionController {

    private final GameHolder gameHolder;
    private final PlayerActionService playerActionService;

    @MessageMapping("place/")
    @SendTo("/topic/game/board/")
    public GameStateDto place(@Payload PlaceActionDto placeActionDto) {

        System.out.println("placeActionDto: " + placeActionDto);
        Game game = gameHolder.getDefaultGame();

        Integer id = placeActionDto.getBuildingType();
        BuildingType buildingType = BuildingType.fromId(id);
        playerActionService.placeDefaultBuilding(game, buildingType,
                placeActionDto.getX(), placeActionDto.getY());

        return map(game.getBoard());
    }

    @MessageMapping("place/crop/")
    @SendTo("/topic/game/board/")
    public GameStateDto placeWithCropType(@Payload PlaceCropTypedActionDto placeActionDto) {
        System.out.println("place crop type action dto: " + placeActionDto);

        Game game = gameHolder.getDefaultGame();

        Integer id = placeActionDto.getBuildingType();
        BuildingType buildingType = BuildingType.fromId(id);

        String crop = placeActionDto.getCrop();

        playerActionService.placeDefaultBuilding(game, buildingType, placeActionDto.getX(), placeActionDto.getY());

        return map(game.getBoard());
    }

    private GameStateDto map(Board board) {
        GameStateDto gameStateDto = new GameStateDto();
        gameStateDto.setX(board.getXSize());
        gameStateDto.setY(board.getYSize());

        for (Field[] row : board.getMatrix()) {
            for (Field field : row) {
                BuildingType type = field.getBuilding() != null ? field.getBuilding().type() : null;
                TileDto tileDto = new TileDto(field.getX(), field.getY(), field.getFieldType(), type);
                gameStateDto.getTiles().add(tileDto);
            }
        }
        return gameStateDto;
    }


}
