package dev.denny.librarries;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import dev.denny.librarries.entity.EntityFactory;
import dev.denny.librarries.entity.NPC;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

    @EventHandler
    public void onLeftClickEntity(EntityDamageByEntityEvent event) {
        Entity victum = event.getEntity();
        Entity damager = event.getDamager();

        ((Player) damager).sendMessage("1");
        if(!(victum instanceof NPC)) {
            ((Player) damager).sendMessage("2");

            return;
        }
        ((Player) damager).sendMessage("3");

        if (!(damager instanceof Player)) {
            ((Player) damager).sendMessage("4");

            return;
        }
        ((Player) damager).sendMessage("5");


        EntityFactory.handleNPCController((Player) damager, (NPC) victum, ((NPC) victum).getController());
    }
}