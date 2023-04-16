package dev.denny.librarries.utils;

import cn.nukkit.Player;
import dev.denny.librarries.entity.NPC;

public interface NPCController {

    void handle(NPC clickedNPC, Player player);
}