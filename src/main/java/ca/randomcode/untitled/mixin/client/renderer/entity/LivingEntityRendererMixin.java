package ca.randomcode.untitled.mixin.client.renderer.entity;

import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin <T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> implements RenderLayerParent<T, M> {
    protected LivingEntityRendererMixin(EntityRendererProvider.Context context) {
        super(context);
    }

    public M getModel() {
        return null;
    }

    public ResourceLocation getTextureLocation(T entity) {
        return null;
    }

    /**
     * @author
     * @reason
     *
    @Overwrite
    public static boolean isEntityUpsideDown(LivingEntity livingEntity) {
        if (livingEntity instanceof Player || livingEntity.hasCustomName()) {
            String string = ChatFormatting.stripFormatting(livingEntity.getName().getString());
            if ("Dinnerbone".equals(string) || "Grumm".equals(string) || "MobSlicer".equals(string)) {
                return !(livingEntity instanceof Player) || ((Player)livingEntity).isModelPartShown(PlayerModelPart.CAPE);
            }
        }

        return false;
    }*/
}
