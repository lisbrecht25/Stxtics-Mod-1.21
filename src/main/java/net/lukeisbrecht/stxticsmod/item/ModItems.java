package net.lukeisbrecht.stxticsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lukeisbrecht.stxticsmod.StxticsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item NOCTURA_SAPLING = registerItem("noctura_sapling", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StxticsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StxticsMod.LOGGER.info("Registering Mod Items for " + StxticsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
           entries.add(NOCTURA_SAPLING);
        });
    }

}
