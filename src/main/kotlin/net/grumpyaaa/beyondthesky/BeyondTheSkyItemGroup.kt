package net.grumpyaaa.beyondthesky

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.grumpyaaa.beyondthesky.blocks.ModBlocks
import net.grumpyaaa.beyondthesky.items.ModItems
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object BeyondTheSkyItemGroup {

    var creativeTab: CreativeModeTab = FabricItemGroup.builder()
        .icon { ItemStack(ModItems.carbonDioxideScrubber) }
        .title(Component.translatable("itemGroup.${BeyondTheSky.modId}.creativetab"))
        .displayItems { itemDisplayParameters, output ->
            output.accept(ModItems.carbonDioxideScrubber)
            output.accept(ModBlocks.launchPad)
        }
        .build()
}