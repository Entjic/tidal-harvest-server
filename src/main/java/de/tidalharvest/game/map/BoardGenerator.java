package de.tidalharvest.game.map;


import de.tidalharvest.game.model.board.Board;
import de.tidalharvest.game.model.board.Field;
import de.tidalharvest.game.model.board.FieldType;
import org.springframework.stereotype.Component;

@Component
public class BoardGenerator {


    public Board generateBoard(int x, int y, double rockParam) {

        Board board = new Board(x, y);

        for (int i = 0; i < board.getXSize(); i++) {
            for (int j = 0; j < board.getYSize(); j++) {
                board.getMatrix()[i][j] = generate(i, j, rockParam);
            }
        }

        return board;

    }

    private Field generate(int x, int y, double rockParam) {

        Field field = new Field();
        field.setX(x);
        field.setY(y);

        double random = (1 / rockParam) * Math.random();
        if (random <= 1) {
            return field;
        }

        field.setFieldType(FieldType.FARMLAND);
        System.out.println(field.getX() + " " + field.getY());
        return field;
    }


}
