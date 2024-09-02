package de.tidalharvest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameStateDto {

    private Long gameId = 0L;
    private int x,y;
    private Collection<TileDto> tiles = new ArrayList<>();

}
