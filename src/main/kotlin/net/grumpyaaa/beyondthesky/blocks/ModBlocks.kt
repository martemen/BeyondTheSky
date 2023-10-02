package net.grumpyaaa.beyondthesky.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.grumpyaaa.beyondthesky.BeyondTheSky
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks

object ModBlocks {
    val launchPad = registerBlock("launchpad", LaunchPad(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)))

    fun registerBlock(name: String, block: Block): Block {
        registerBlockItem(name, block)
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation(BeyondTheSky.modId, name), block)
    }

    fun registerBlockItem(name: String, block: Block): Item {
        return Registry.register(
            BuiltInRegistries.ITEM, ResourceLocation(BeyondTheSky.modId, name),
            BlockItem(block, FabricItemSettings())
        )
    }

    fun registerBlocks() {}
}