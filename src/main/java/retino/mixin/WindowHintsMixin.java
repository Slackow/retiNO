package retino.mixin;

import com.mojang.blaze3d.platform.Window;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Window.class)
public abstract class WindowHintsMixin {
	@Inject(
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/blaze3d/platform/Window;createWindow(Lcom/mojang/blaze3d/systems/GpuBackend;IILjava/lang/String;J)J"
		),
		method = "<init>"
	)
	private void adjustWindowHints(CallbackInfo callbackInfo) {
		GLFW.glfwWindowHint(GLFW.GLFW_COCOA_RETINA_FRAMEBUFFER, GLFW.GLFW_FALSE);
	}
}
