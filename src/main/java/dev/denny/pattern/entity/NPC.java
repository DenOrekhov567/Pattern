package dev.denny.pattern.entity;

import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import dev.denny.pattern.utils.NPCController;
import dev.denny.pattern.utils.Utils;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class NPC extends EntityBase {

    @Setter
    @Getter
    private NPCController controller;

    public NPC(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public void setSkinFrom(String pathPlugin, String imageName) {
        setSkin(Utils.from(new File(pathPlugin + "/").toPath().resolve(imageName)));
    }

    public void setTitle(String title) {
        setNameTagAlwaysVisible(true);
        setNameTag(title);
    }
}