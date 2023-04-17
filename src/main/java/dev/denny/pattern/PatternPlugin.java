package dev.denny.pattern;

import cn.nukkit.entity.Entity;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.PluginBase;
import dev.denny.pattern.entity.*;
import dev.denny.pattern.utils.Utils;

import java.io.File;

public class PatternPlugin extends PluginBase {

    @Override
    public void onEnable() {
        registerComponents();
    }

    private void registerComponents() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        Entity.registerEntity("NPC", NPC.class);
        Entity.registerEntity("Hologram", Hologram.class);

        lol();
    }

    private void lol() {
        Location location = new Location(-41.5, 33, -38.5, 90, 0, getServer().getLevelByName("spawn"));

        EntityFactory.prepare(location);

        Hologram hologram = EntityFactory.createHologram(location, "Test_NPC1");
        hologram.setText("my text 2");
        hologram.build();

        NPC npc = EntityFactory.createNPC(location, "Test_Hologram1");
        npc.setSkinFrom(String.valueOf(getDataFolder()), "skin.png");
        npc.setTitle("Скупщик");
        npc.setScale(3);
        npc.setController(
                (clickedNPC, player) -> player.sendMessage("lol")
        );
        npc.build();
    }
}