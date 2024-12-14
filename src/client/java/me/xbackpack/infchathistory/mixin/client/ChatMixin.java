package me.xbackpack.infchathistory.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChatComponent.class)
public class ChatMixin {
	@ModifyExpressionValue(
			method = {
					"addMessageToQueue",
					"addMessageToDisplayQueue",
					"addRecentChat"
			},
			at = @At(value = "CONSTANT", args = "intValue=100")
	)
	private int changeHist(int original) {
		return 2147483646;
	}
}