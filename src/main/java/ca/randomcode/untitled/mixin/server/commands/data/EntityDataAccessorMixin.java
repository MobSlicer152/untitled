package ca.randomcode.untitled.mixin.server.commands.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.commands.data.DataAccessor;
import net.minecraft.server.commands.data.EntityDataAccessor;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.UUID;

@Mixin(EntityDataAccessor.class)
public abstract class EntityDataAccessorMixin implements DataAccessor {
    @Shadow
    private Entity entity;

    /**
     * @author MobSlicer152
     * @reason trolling
     */
    @Overwrite()
    public void setData(CompoundTag compoundTag) {
        if (this.entity instanceof Player) {
            this.entity.sendSystemMessage(MutableComponent.create(new TranslatableContents("", compoundTag.toString(), new Object[]{})));
        }

        UUID uUID = this.entity.getUUID();
        this.entity.load(compoundTag);
        this.entity.setUUID(uUID);
    }
}
