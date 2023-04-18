package dev.denny.pattern;

import cn.nukkit.entity.Entity;
import cn.nukkit.plugin.PluginBase;
import dev.denny.pattern.entity.*;

public class PatternPlugin extends PluginBase {

    @Override
    public void onEnable() {
        registerComponents();
    }

    private void registerComponents() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        Entity.registerEntity("NPC", NPC.class);
        Entity.registerEntity("Hologram", Hologram.class);
    }
}