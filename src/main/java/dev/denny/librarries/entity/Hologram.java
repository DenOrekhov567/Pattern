package dev.denny.librarries.entity;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class Hologram extends EntityBase {

    public Hologram(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public void setText(String name) {
        setNameTag(name);
    }
}