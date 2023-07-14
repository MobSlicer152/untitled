package ca.randomcode.untitled.world.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class FaradayArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return 16;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return 6;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_CHAIN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.IRON_NUGGET);
    }

    @Override
    public String getName() {
        return "chainmail";
    }

    @Override
    public float getToughness() {
        return 2.4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.1f;
    }
}
