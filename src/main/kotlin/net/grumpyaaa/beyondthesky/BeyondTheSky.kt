package net.grumpyaaa.beyondthesky

import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.grumpyaaa.beyondthesky.BeyondTheSkyItemGroup.creativeTab
import net.grumpyaaa.beyondthesky.items.ModItems
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory


object BeyondTheSky : ModInitializer {
	const val modId: String = "beyondthesky";
    val logger: Logger = LoggerFactory.getLogger("beyondthesky")

	override fun onInitialize() {
		Registry.register(Registries.ITEM_GROUP, Identifier(modId, "creativetab"), creativeTab)
		ModItems.registerItems()
	}
}