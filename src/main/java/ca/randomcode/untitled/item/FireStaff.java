package ca.randomcode.untitled.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class FireStaff extends Item implements FabricItem {

    public FireStaff(FabricItemSettings properties) {
        super(properties.fireResistant().craftRemainder(Blocks.FIRE.asItem()));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        Vec3 direction = player.getLookAngle().normalize().multiply(3, 3, 3);
        Projectile fireball = new LargeFireball(level, player, direction.x, direction.y, direction.z,
                player.getItemInHand(interactionHand).getDamageValue());
        fireball.setPos(player.getEyePosition());
        level.addFreshEntity(fireball);
        return super.use(level, player, interactionHand);
    }
}
