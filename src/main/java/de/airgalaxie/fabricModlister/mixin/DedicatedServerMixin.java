package de.airgalaxie.fabricModlister.mixin;

import de.airgalaxie.fabricModlister.ModList;
import net.minecraft.server.dedicated.DedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DedicatedServer.class)
abstract class DedicatedServerMixin {
    @Inject(method = "getPluginNames", at = @At("HEAD"), cancellable = true)
    private void fabricModlister$publishMods(CallbackInfoReturnable<String> callback) {
        callback.setReturnValue(ModList.forQuery());
    }
}
