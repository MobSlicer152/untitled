package ca.randomcode.untitled.world.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireStaff extends StaffItem {
    public FireStaff(Properties properties) {
        super(properties);
    }

    @Override
    public boolean fire(Level level, LivingEntity user, ItemStack stack, Vec3 direction, double power) {
        if (power >= 0.01) {
            LargeFireball ball = new LargeFireball(level, user, direction.x, direction.y, direction.z, (int) (power * 5));
            ball.setPos(user.getEyePosition());
            level.addFreshEntity(ball);
            return true;
        } else {
            return false;
        }
    }
}
