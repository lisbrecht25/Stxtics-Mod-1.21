package net.lukeisbrecht.stxticsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lukeisbrecht.stxticsmod.StxticsMod;
import net.lukeisbrecht.stxticsmod.block.ModBlocks;
import net.lukeisbrecht.stxticsmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NOCTURA_PLANKS)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.NOCTURA_SAPLING)
                .criterion(hasItem(ModItems.NOCTURA_SAPLING), conditionsFromItem(ModItems.NOCTURA_SAPLING))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NOCTURA_SAPLING, 4)
                .input(ModBlocks.NOCTURA_PLANKS)
                .criterion(hasItem(ModBlocks.NOCTURA_PLANKS), conditionsFromItem(ModBlocks.NOCTURA_PLANKS))
                .offerTo(recipeExporter, Identifier.of(StxticsMod.MOD_ID, "noctura_planks_from_noctura_sapling"));

    }
}
