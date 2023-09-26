package net.grumpyaaa.beyondthesky.mixin;

import net.grumpyaaa.beyondthesky.BeyondTheSky;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "wakeUpAllPlayers")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
		//info.cancel();
	}
}