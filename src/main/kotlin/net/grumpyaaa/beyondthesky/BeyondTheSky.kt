package net.grumpyaaa.beyondthesky

import net.fabricmc.api.ModInitializer
import net.grumpyaaa.beyondthesky.BeyondTheSkyItemGroup.creativeTab
import net.grumpyaaa.beyondthesky.blocks.ModBlocks
import net.grumpyaaa.beyondthesky.items.ModItems
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import 	net.minecraft.world.level.pathfinder.SwimNodeEvaluator


object BeyondTheSky : ModInitializer {
	const val modId: String = "beyondthesky";
	@JvmField
	val logger: Logger = LoggerFactory.getLogger("beyondthesky")

	override fun onInitialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation(modId, "creativetab"), creativeTab)
		ModItems.registerItems()
		ModBlocks.registerBlocks()
	}

}