package net.sparklepopprograms.keepinginventory;

import java.io.File;

import cpw.mods.fml.common.Mod;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ModConfiguration {
    private static ModConfiguration s_instance = null;

    private boolean _isKeepInventory;

    private boolean _isMobGriefing;

    public static ModConfiguration getInstance() {
        if (s_instance == null) {
            s_instance = new ModConfiguration();
        }

        return s_instance;
    }

    public boolean isKeepInventory() {
        return _isKeepInventory;
    }

    public boolean isMobGriefing() {
        return _isMobGriefing;
    }

    private ModConfiguration() {
    }

    public void load() {
        File mainFile = new File("config/Silly511/KeepingInventory.cfg");
        Configuration config = new Configuration(mainFile);
        config.load();

        _isKeepInventory = config.get(Configuration.CATEGORY_GENERAL, "KeepInventory", true).getBoolean();
        _isMobGriefing = config.get(Configuration.CATEGORY_GENERAL, "MobGriefing", false).getBoolean();

        boolean isNewConfigurationFile = config.hasChanged();
        if (isNewConfigurationFile) {
            config.save();
        }
    }
}
