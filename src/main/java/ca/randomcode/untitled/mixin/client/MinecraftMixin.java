package ca.randomcode.untitled.mixin.client;

import com.mojang.blaze3d.platform.WindowEventHandler;
import net.minecraft.SharedConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin extends ReentrantBlockableEventLoop implements WindowEventHandler {

    public MinecraftMixin(String string) {
        super(string);
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    private String createTitle() {
        return "Minecraft v" + SharedConstants.getCurrentVersion().getName() + " protocol " +
                SharedConstants.getProtocolVersion() + " built on " + SharedConstants.getCurrentVersion().getBuildTime();
    }
}
