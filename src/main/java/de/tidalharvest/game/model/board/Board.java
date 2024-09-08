package de.tidalharvest.game.model.board;


import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class Board {

    private final Integer xSize;
    private final Integer ySize;

    private final Field[][] matrix;

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.matrix = new Field[xSize][ySize];
    }

}
