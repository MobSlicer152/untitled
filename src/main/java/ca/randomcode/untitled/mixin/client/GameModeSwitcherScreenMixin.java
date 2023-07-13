package ca.randomcode.untitled.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.debug.GameModeSwitcherScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Optional;

@Mixin(GameModeSwitcherScreen.class)
public abstract class GameModeSwitcherScreenMixin extends Screen {
    protected GameModeSwitcherScreenMixin(Component component) {
        super(component);
    }

    @Inject(method = "switchToHoveredGameMode", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void switchToHoveredGameMode(CallbackInfo callbackInfo, Minecraft minecraft, Optional<Enum<?>> optional) {
        /*String gamemode = optional.get().toString();
        if (!minecraft.player.hasPermissions(2)) {
            if (gamemode == "CREATIVE") {
                minecraft.player.chat("/gmc");
            } else if (gamemode == "SURVIVAL") {
                minecraft.player.chat("/gms");
            } else if (gamemode == "SPECTATOR") {
                minecraft.player.chat("/gmsp");
            } else if (gamemode == "ADVENTURE") {
                minecraft.player.chat("/gma");
            }
        }*/
    }
}
