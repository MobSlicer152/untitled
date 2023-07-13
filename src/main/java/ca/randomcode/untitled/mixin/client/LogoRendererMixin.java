package ca.randomcode.untitled.mixin.client;

import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @Shadow private boolean showEasterEgg;

    @Inject(method = "<init>(Z)V", at = @At("TAIL"))
    public void TitleScreen(CallbackInfo callbackInfo) {
        this.showEasterEgg = true;
    }
}
