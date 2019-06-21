package net.sparklepopprograms.keepinginventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.GameRules;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ConnectionHandler {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        GameRules gameRules = MinecraftServer.getServer().worldServerForDimension(0).getGameRules();
        ModConfiguration configuration = ModConfiguration.getInstance();
        setBooleanGameRule(gameRules, "keepInventory", configuration.isKeepInventory());
        setBooleanGameRule(gameRules, "mobGriefing", configuration.isMobGriefing());

        if (configuration.isKeepInventory()) {
            addPlayerChatMessage(event.player, "Your inventory will be kept on death.");
        } else {
            addPlayerChatMessage(event.player, "Your inventory will not be kept on death.");
        }

        if (configuration.isMobGriefing()) {
            addPlayerChatMessage(event.player, "Creepers will destroy blocks.");
        } else {
            addPlayerChatMessage(event.player, "Creepers will not destroy blocks.");
        }
    }

    private void setBooleanGameRule(GameRules rules, String ruleName, boolean value){
        rules.setOrCreateGameRule(ruleName, String.valueOf(value).toLowerCase());
    }

    private void addPlayerChatMessage(EntityPlayer player, String message) {
        player.addChatMessage(new ChatComponentTranslation(EnumChatFormatting.BLUE + "[KeepingInventory] " + EnumChatFormatting.WHITE + message));
    }
}
