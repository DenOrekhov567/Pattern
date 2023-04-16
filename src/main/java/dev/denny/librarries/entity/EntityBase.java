package dev.denny.librarries.entity;

import cn.nukkit.entity.EntityHuman;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
import lombok.Getter;
import lombok.Setter;

public class EntityBase extends EntityHuman {

    @Setter
    @Getter
    public String uniqueTag;

    public EntityBase(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public boolean onUpdate(int currentTick) {
        return false;
    }

    public void build() {
        spawnToAll();
    }

    //Для удаления сохранения NBT-структуры
    //Они не будут сохраняться в мире
    @Override
    public void saveNBT() {}
}