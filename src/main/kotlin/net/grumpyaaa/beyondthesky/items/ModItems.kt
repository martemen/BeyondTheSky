package net.grumpyaaa.beyondthesky.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.grumpyaaa.beyondthesky.BeyondTheSky.modId
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModItems {
    companion object {

        val carbonDioxideScrubber: Item = registerItem("carbondioxidescrubber", Item(FabricItemSettings()))

        private fun registerItem(name: String, item: Item): Item {
            return Registry.register(Registries.ITEM, Identifier(modId, name), item)
        }


        //Need for the items to be initialized
        fun registerItems() {}
    }
}