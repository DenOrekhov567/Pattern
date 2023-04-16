package dev.denny.librarries.entity;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import dev.denny.librarries.utils.NPCController;
import lombok.Getter;
import lombok.Setter;

public class NPC extends EntityBase {

    @Setter
    @Getter
    private NPCController controller;

    public NPC(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
}