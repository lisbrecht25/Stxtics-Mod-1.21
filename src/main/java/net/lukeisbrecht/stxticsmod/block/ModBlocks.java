package net.lukeisbrecht.stxticsmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lukeisbrecht.stxticsmod.StxticsMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block NOCTURA_PLANKS = registerBlock("noctura_planks",
            new Block(AbstractBlock.Settings.create().strength(2.0F, 3.0F).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_STAIRS = registerBlock("noctura_stairs",
            new StairsBlock(ModBlocks.NOCTURA_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_SLAB = registerBlock("noctura_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_BUTTON = registerBlock("noctura_button",
            new ButtonBlock(BlockSetType.OAK, 10,
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().noCollision()));

    public static final Block NOCTURA_PRESSURE_PLATE = registerBlock("noctura_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_FENCE = registerBlock("noctura_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_FENCE_GATE = registerBlock("noctura_fence_gate",
            new FenceGateBlock(WoodType.OAK,
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_WALL = registerBlock("noctura_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable()));

    public static final Block NOCTURA_DOOR = registerBlock("noctura_door",
            new DoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));

    public static final Block NOCTURA_TRAPDOOR = registerBlock("noctura_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,
                    AbstractBlock.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StxticsMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StxticsMod.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        StxticsMod.LOGGER.info("Registering Mod Blocks for " + StxticsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.NOCTURA_PLANKS);
            entries.add(ModBlocks.NOCTURA_STAIRS);
            entries.add(ModBlocks.NOCTURA_SLAB);
            entries.add(ModBlocks.NOCTURA_BUTTON);
            entries.add(ModBlocks.NOCTURA_PRESSURE_PLATE);
            entries.add(ModBlocks.NOCTURA_FENCE);
            entries.add(ModBlocks.NOCTURA_FENCE_GATE);
            entries.add(ModBlocks.NOCTURA_WALL);
            entries.add(ModBlocks.NOCTURA_DOOR);
            entries.add(ModBlocks.NOCTURA_TRAPDOOR);

        });
    }
}
