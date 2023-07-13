package ca.randomcode.untitled;

import ca.randomcode.untitled.item.FireStaff;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class Untitled implements ModInitializer {
    public static final String MOD_ID = "untitled";
    public static final Item FIRE_STAFF = new FireStaff(new FabricItemSettings());

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, "fire_staff"), FIRE_STAFF);
    }
}
