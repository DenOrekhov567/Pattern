package dev.denny.pattern.entity;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

public class Hologram extends EntityBase {

    public Hologram(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public void setText(String name) {
        setNameTag(name);
    }

    @Override
    public void build() {
        super.build();

        setNameTagAlwaysVisible(true);
        setScale(Float.valueOf(0.00001F));
    }
}