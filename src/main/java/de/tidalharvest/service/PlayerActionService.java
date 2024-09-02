package de.tidalharvest.service;


import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.board.FieldType;
import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.model.building.Building;
import de.tidalharvest.game.model.building.BuildingType;
import de.tidalharvest.game.model.building.Farm;
import de.tidalharvest.game.model.worker.pathfinding.Coordinate;
import de.tidalharvest.game.model.worker.task.TaskQueue;
import de.tidalharvest.game.model.worker.task.farmer.PlantTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerActionService {

    private final TaskQueue taskQueue;

    public void placeDefaultBuilding(Game game, BuildingType type, Integer x, Integer y) {
        Board board = game.getBoard();
        if (!(x >= 0 && x < board.getXSize())) throw new IllegalArgumentException();
        if (!(y >= 0 && y < board.getYSize())) throw new IllegalArgumentException();

        Field field = board.getMatrix()[x][y];

        if (!field.getFieldType().equals(FieldType.FARMLAND)) throw new IllegalArgumentException();

        Building building;
        switch (type) {
            case FARM -> {
                building = new Farm(x, y);
                Set<Coordinate> neighbouring = getNeighbouring(building, board.getXSize(), board.getYSize());
                for (Coordinate coordinate : neighbouring) {
                    if (board.getMatrix()[coordinate.x()][coordinate.y()].getFieldType().equals(FieldType.FARMLAND)) {
                        taskQueue.schedule(game.getId(), new PlantTask(coordinate.x(), coordinate.y()));
                    }
                }

            }
            case SILO, BARRACK -> throw new UnsupportedOperationException();
            case null, default -> throw new IllegalArgumentException();
        }
        field.setBuilding(building);

    }

    private Set<Coordinate> getNeighbouring(Building building, int xBound, int yBound) {
        Set<Coordinate> neighbours = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                Coordinate coordinate = new Coordinate(building.x() + i, building.y() + j);
                if (!coordinate.valid(xBound, yBound)) continue;
                neighbours.add(coordinate);
            }
        }
        return neighbours;
    }

    private void buy(Game game, BuildingType type) {

    }

}
