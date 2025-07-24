package net.lukeisbrecht.stxticsmod;

import net.fabricmc.api.ModInitializer;

import net.lukeisbrecht.stxticsmod.block.ModBlocks;
import net.lukeisbrecht.stxticsmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StxticsMod implements ModInitializer {
	public static final String MOD_ID = "stxticsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}