package dev.denny.librarries.entity;

import cn.nukkit.Player;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.level.Location;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.utils.SerializedImage;
import cn.nukkit.entity.Entity;
import dev.denny.librarries.utils.NPCController;

public class EntityFactory {

    private static final Skin EMPTY_SKIN = new Skin();

    private static final SerializedImage SKIN_DATA = SerializedImage.fromLegacy(new byte[8192]);

    public static void prepare(Location location) {
        location.getLevel().loadChunk(location.getChunkX(), location.getChunkZ());
    }

    public static NPC createNPC(Location location, String uniqueTag) {
        Skin skin = new Skin();
        skin.setSkinData(SKIN_DATA);
        skin.generateSkinId(uniqueTag);

        CompoundTag nbt = Entity.getDefaultNBT(location)
                .putString("Name", uniqueTag)
                .putCompound("Skin", (new CompoundTag())
                        .putByteArray("Data", skin.getSkinData().data)
                        .putString("ModelId", skin.getSkinId())
                )
        ;

        NPC npc = new NPC(location.getChunk(), nbt);

        EntityManager.addEntity(uniqueTag, npc);

        return npc;
    }

    public static Hologram createHologram(Location location, String uniqueTag) {
        Skin skin = new Skin();
        skin.setSkinData(SKIN_DATA);
        skin.generateSkinId(uniqueTag);

        CompoundTag nbt = Entity.getDefaultNBT(location)
                .putString("Name", uniqueTag)
                .putCompound("Skin", (new CompoundTag())
                        .putByteArray("Data", skin.getSkinData().data)
                        .putString("ModelId", skin.getSkinId())
                )
        ;

        Hologram hologram = new Hologram(location.getChunk(), nbt);

        hologram.setUniqueTag(uniqueTag);
        hologram.setNameTagAlwaysVisible(true);
        hologram.setScale(Float.valueOf(0.00001F));

        EntityManager.addEntity(uniqueTag, hologram);

        return hologram;
    }

    public static void handleNPCController(Player player, NPC npc, NPCController controller) {
        if (controller == null) {
            return;
        }

        controller.handle(npc, player);
    }
}