package net.grumpyaaa.beyondthesky.utils

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import net.grumpyaaa.beyondthesky.BeyondTheSky
import org.joml.Vector3d
import org.joml.Vector3dc
import org.valkyrienskies.core.api.ships.PhysShip
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.getAttachment
import org.valkyrienskies.core.api.ships.saveAttachment
import org.valkyrienskies.core.impl.api.ServerShipUser
import org.valkyrienskies.core.impl.api.ShipForcesInducer
import org.valkyrienskies.core.impl.api.Ticked
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl
import org.valkyrienskies.core.impl.pipelines.SegmentUtils
import org.valkyrienskies.core.impl.util.y


@JsonAutoDetect(
    fieldVisibility = JsonAutoDetect.Visibility.ANY,
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    setterVisibility = JsonAutoDetect.Visibility.NONE,
)
@JsonIgnoreProperties()
class ShipController : ShipForcesInducer, ServerShipUser, Ticked {

    @JsonIgnore
    override var ship: ServerShip? = null

    override fun applyForces(physShip: PhysShip) {
        physShip as PhysShipImpl

        val mass = physShip.inertia.shipMass
        val moiTensor = physShip.inertia.momentOfInertiaTensor
        val segment = physShip.segments.segments[0]?.segmentDisplacement!!
        val omega: Vector3dc = SegmentUtils.getOmega(physShip.poseVel, segment, Vector3d())
        val vel = SegmentUtils.getVelocity(physShip.poseVel, segment, Vector3d())
        val ship = ship ?: return

        physShip.applyInvariantForce(Vector3d(0.0, forcePerThruster * thrusters, 0.0))
        BeyondTheSky.logger.info(vel.toString())
        BeyondTheSky.logger.info(("Altitude: " + ship.transform.positionInWorld.y.toString()))
        if(ship.transform.positionInWorld.y > 100000) {

            BeyondTheSky.logger.info("SPACE!")
        }
    }
    var thrusters = 0 // Amount of thrusters
        set(v) {
            field = v; deleteIfEmpty()
        }

    override fun tick() {}

    private fun deleteIfEmpty() {
        if (thrusters == 0) {
            ship?.saveAttachment<ShipController>(null)
        }
    }

    companion object {

        const val forcePerThruster = 227882400.23306 //test thrust
        fun getOrCreate(ship: ServerShip): ShipController {
            return ship.getAttachment<ShipController>()
                ?: ShipController().also { ship.saveAttachment(it) }
        }
    }
}