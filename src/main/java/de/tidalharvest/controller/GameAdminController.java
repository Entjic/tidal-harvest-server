package de.tidalharvest.controller;

import de.tidalharvest.dto.GameStateDto;
import de.tidalharvest.game.model.Game;
import de.tidalharvest.game.GameHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@MessageMapping("/game/admin/")
public class GameAdminController {

    private final GameHolder gameHolder;

    @MessageMapping("create/")
    @SendTo("/topic/game/created/")
    public Game create() {
        return gameHolder.getDefaultGame();
    }

}
