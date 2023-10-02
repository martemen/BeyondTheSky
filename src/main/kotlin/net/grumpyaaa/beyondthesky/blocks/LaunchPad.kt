package net.grumpyaaa.beyondthesky.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.grumpyaaa.beyondthesky.BeyondTheSky
import net.grumpyaaa.beyondthesky.utils.ShipController
import net.grumpyaaa.beyondthesky.utils.ShipUtils
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.mod.common.getShipManagingPos
import org.valkyrienskies.mod.common.getShipObjectManagingPos


class LaunchPad(settings: FabricBlockSettings) : Block(settings) {
    override fun onPlace(
        blockState: BlockState,
        level: Level,
        blockPos: BlockPos,
        blockState2: BlockState,
        bl: Boolean
    ) {
        super.onPlace(blockState, level, blockPos, blockState2, bl)
        if(level.isClientSide) return
        level as ServerLevel
        val ship = level.getShipObjectManagingPos(blockPos) ?: level.getShipManagingPos(blockPos) ?: return
        val shipController = ShipController.getOrCreate(ship)
        shipController.ship = ship
        shipController.thrusters += 1
        BeyondTheSky.logger.info("a")
    }

    @Deprecated("Deprecated in Java")
    override fun use(
        blockState: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        interactionHand: InteractionHand,
        blockHitResult: BlockHitResult
    ): InteractionResult {
        if(!level.isClientSide) {
            if (level.hasNeighborSignal(pos)) {
                level.server!!.playerList.players[0].displayClientMessage(Component.literal(":)"), true)
                val serverLevel = level as ServerLevel

                val ship = serverLevel.getShipObjectManagingPos(pos)
                if (ship != null) {
                    println("s")
                } else {
                    ShipUtils.collectBlocks(
                        serverLevel,
                        pos,
                    ) { !it.isAir }
                }
            }
        }

        return InteractionResult.SUCCESS
    }

//    override fun tick(
//        blockState: BlockState,
//        serverLevel: ServerLevel,
//        blockPos: BlockPos,
//        randomSource: RandomSource
//    ) {
//        super.tick(blockState, serverLevel, blockPos, randomSource)
//    }

    override fun onRemove(
        blockState: BlockState,
        level: Level,
        blockPos: BlockPos,
        blockState2: BlockState,
        bl: Boolean
    ) {
        super.onRemove(blockState, level, blockPos, blockState2, bl)
        if(level.isClientSide) return
        val ship = level.getShipObjectManagingPos(blockPos) ?: level.getShipManagingPos(blockPos) ?: return
        val shipController = ShipController.getOrCreate(ship as ServerShip)
        shipController.thrusters -= 1
    }
}