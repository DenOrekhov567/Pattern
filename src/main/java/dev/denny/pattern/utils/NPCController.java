package dev.denny.pattern.utils;

import cn.nukkit.Player;
import dev.denny.pattern.entity.NPC;

public interface NPCController {

    void handle(NPC clickedNPC, Player player);
}