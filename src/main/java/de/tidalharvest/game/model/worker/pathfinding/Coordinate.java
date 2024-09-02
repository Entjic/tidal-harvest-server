package de.tidalharvest.game.model.worker.pathfinding;

public record Coordinate(int x, int y) {

    public boolean valid(int boundX, int boundY){
        return x >= 0 && y >= 0 && x < boundX && y < boundY;
    }
}
