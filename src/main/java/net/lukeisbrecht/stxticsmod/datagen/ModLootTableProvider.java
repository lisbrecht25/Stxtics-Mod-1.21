package net.lukeisbrecht.stxticsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lukeisbrecht.stxticsmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.NOCTURA_PLANKS);
        addDrop(ModBlocks.NOCTURA_STAIRS);
        addDrop(ModBlocks.NOCTURA_SLAB, slabDrops(ModBlocks.NOCTURA_SLAB));
        addDrop(ModBlocks.NOCTURA_BUTTON);
        addDrop(ModBlocks.NOCTURA_PRESSURE_PLATE);
        addDrop(ModBlocks.NOCTURA_WALL);
        addDrop(ModBlocks.NOCTURA_FENCE);
        addDrop(ModBlocks.NOCTURA_FENCE_GATE);
        addDrop(ModBlocks.NOCTURA_DOOR, doorDrops(ModBlocks.NOCTURA_DOOR));
        addDrop(ModBlocks.NOCTURA_TRAPDOOR);

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

}

