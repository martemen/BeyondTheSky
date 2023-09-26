package net.grumpyaaa.beyondthesky.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.grumpyaaa.beyondthesky.utils.ShipUtils
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.network.TextFilter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState


class LaunchPad(settings: FabricBlockSettings) : Block(settings) {

    @Deprecated("Deprecated in Java")
    override fun neighborChanged(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        block: Block,
        fromPos: BlockPos,
        isMoving: Boolean
    ) {
                if (level.isClientSide) {
            return
        }
        if (level.hasNeighborSignal(pos)) {

        }
    }
}