package ca.randomcode.untitled.world.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class StaffItem extends Item implements FabricItem {
    public StaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand interactionHand) {
        ItemStack stack = user.getItemInHand(interactionHand);
        Vec3 direction = user.getLookAngle().normalize();

        return fire(level, user, stack, direction, (double)(stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage()) ?
                InteractionResultHolder.pass(stack) :
                    InteractionResultHolder.fail(stack);
    }

    public abstract boolean fire(Level level, LivingEntity user, ItemStack stack, Vec3 direction, double power);
}
