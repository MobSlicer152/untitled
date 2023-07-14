package ca.randomcode.untitled;

import ca.randomcode.untitled.world.item.FaradayArmorMaterial;
import ca.randomcode.untitled.world.item.FireStaff;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.recipe.v1.ingredient.FabricIngredient;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Untitled implements ModInitializer {
    public static final String MOD_ID = "untitled";
    public static Logger logger;

    public static final Item FIRE_STAFF = registerItem(new FireStaff(new FabricItemSettings().rarity(Rarity.EPIC)
            .fireResistant().durability(1000)), "fire_staff");

    public static final ArmorMaterial FARADAY_MATERIAL = new FaradayArmorMaterial();
    public static final Item FARADAY_SUIT = registerItem(new ArmorItem(FARADAY_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(50).rarity(Rarity.UNCOMMON)), "faraday_suit");

    public static final CreativeModeTab MOD_TAB = CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 6)
            .title(Component.translatable("itemGroup.untitled"))
            .icon(() -> {
                return new ItemStack(FIRE_STAFF);
            }).displayItems((itemDisplayParameters, output) -> {
                output.accept(FIRE_STAFF);
                output.accept(FARADAY_SUIT);
            }).build();

    public static final MobEffect REACH = registerEffect(new MobEffect(MobEffectCategory.BENEFICIAL, Mth.color(0.7f, 0.0f, 1.0f))
                .addAttributeModifier(ReachEntityAttributes.REACH, "3291652a-a28c-40fc-a382-c193cb0ef291",
                    5.0, AttributeModifier.Operation.ADDITION), "reach", 1);

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        logger = LogManager.getLogger(MOD_ID);
    }

    static Item registerItem(Item item, String name) {
        logger.debug("Registering {} {}", item.getClass(), name);
        return (Item)Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
    }

    static MobEffect registerEffect(MobEffect effect, String name, int id) {
        logger.debug("Registering {} {}", effect.getClass(), name);
        return (MobEffect)Registry.registerMapping(BuiltInRegistries.MOB_EFFECT, id | 0x6900, name, effect);
    }
}
