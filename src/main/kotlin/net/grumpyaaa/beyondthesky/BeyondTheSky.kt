package net.grumpyaaa.beyondthesky

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object BeyondTheSky : ModInitializer {
	val modId: String = "beyondthesky";
    val logger = LoggerFactory.getLogger("beyondthesky")

	override fun onInitialize() {
		logger.info("Hello Fabric world! From, $modId")
	}
}