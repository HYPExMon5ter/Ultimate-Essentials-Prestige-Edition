package net.hypexmon5ter.uepe;

import net.hypexmon5ter.uepe.commands.CommandGamemode;
import org.bukkit.plugin.java.JavaPlugin;

public class UltimateEssentialsPrestigeEdition extends JavaPlugin {

    public void onEnable() {

        getCommand("gamemode").setExecutor(new CommandGamemode(this));
    }

    public void onDisable() {

    }
}
