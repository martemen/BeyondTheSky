package net.grumpyaaa.beyondthesky.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.grumpyaaa.beyondthesky.BeyondTheSky.modId
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item

object ModItems {
    val carbonDioxideScrubber: Item = registerItem("carbondioxidescrubber", Item(FabricItemSettings()))

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(BuiltInRegistries.ITEM,  ResourceLocation(modId, name), item)
    }


    //Need for the items to be initialized
    fun registerItems() {}
}