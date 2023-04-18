package dev.denny.pattern;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import dev.denny.pattern.entity.EntityFactory;
import dev.denny.pattern.entity.NPC;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

    @EventHandler
    public void onLeftClickEntity(EntityDamageByEntityEvent event) {
        Entity victum = event.getEntity();
        Entity damager = event.getDamager();

        if(!(victum instanceof NPC)) {
            return;
        }

        if (!(damager instanceof Player)) {
            return;
        }

        EntityFactory.handleNPCController((Player) damager, (NPC) victum, ((NPC) victum).getController());

        event.setCancelled();
    }
}