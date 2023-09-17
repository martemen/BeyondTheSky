package net.grumpyaaa.beyondthesky

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.grumpyaaa.beyondthesky.items.ModItems
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text

object BeyondTheSkyItemGroup {

    var creativeTab: ItemGroup = FabricItemGroup.builder()
        .icon { ItemStack(ModItems.carbonDioxideScrubber) }
        .displayName(Text.translatable("itemGroup.${BeyondTheSky.modId}.creativetab"))
        .entries { displayContext, entries -> entries.add(ModItems.carbonDioxideScrubber) }
        .build()
}