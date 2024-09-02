package de.tidalharvest.game.model.board;


import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class Board {

    private final Integer xSize;
    private final Integer ySize;

    private final Field[][] matrix = new Field[xSize][ySize];



}
