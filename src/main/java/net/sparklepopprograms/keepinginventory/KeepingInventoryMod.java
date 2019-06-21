package net.sparklepopprograms.keepinginventory;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "KeepingInventory", name = "Keeping Inventory", version = "1.8.1")
public class KeepingInventoryMod {
	@EventHandler
	public void load(FMLInitializationEvent event) {
		ModConfiguration.getInstance().load();
		FMLCommonHandler.instance().bus().register(new ConnectionHandler());
	}
}