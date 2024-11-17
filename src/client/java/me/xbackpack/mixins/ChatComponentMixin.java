package me.xbackpack.mixins;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {
    @ModifyExpressionValue(
            at = @At(value = "CONSTANT", args = "intValue=100"),
            method = {
                "addRecentChat",
                "addMessageToQueue",
                "addMessageToDisplayQueue"
            }
    )
    public int setMaxChatHistory(int original) {
        return Integer.MAX_VALUE;
    }
}
