package dev.denny.librarries;

import cn.nukkit.entity.Entity;
import cn.nukkit.level.Location;
import cn.nukkit.plugin.PluginBase;
import dev.denny.librarries.entity.*;
import dev.denny.librarries.utils.Utils;

import java.io.File;

public class LibrarriesPlugin extends PluginBase {

    @Override
    public void onEnable() {
        registerComponents();
    }

    private void registerComponents() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        Entity.registerEntity("NPC", NPC.class);
        Entity.registerEntity("Hologram", Hologram.class);

        Location location = new Location(-41.5, 33, -38.5, 90, 0, getServer().getLevelByName("spawn"));

        EntityFactory.prepare(location);

        Hologram hologram = EntityFactory.createHologram(location, "Test_NPC1");
        hologram.setText("my text 2");
        hologram.build();

        NPC npc = EntityFactory.createNPC(location, "Test_Hologram1");
        npc.setSkin(Utils.from(new File(getDataFolder() + "").toPath().resolve("skin.png")));
        npc.setScale(3);

        npc.setController(
                (clickedNPC, player) -> player.sendMessage("lol")
        );

        npc.build();
    }
}