package net.hypexmon5ter.uepe.commands;

import net.hypexmon5ter.uepe.UltimateEssentialsPrestigeEdition;
import net.hypexmon5ter.uepe.methods.Misc;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode implements CommandExecutor {

    private String permissionMsg = "You do not have permission to use this command.";

    private Misc m;
    private UltimateEssentialsPrestigeEdition UEPE;

    public CommandGamemode(UltimateEssentialsPrestigeEdition UEPE) {
        this.UEPE = UEPE;
        this.m = new Misc();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage(ChatColor.RED + "Please specify a gamemode.");
            return false;
        }

        if (args.length == 1) {
            m.setGamemode(p, m.decideGamemode(args[0]));
            return true;
        }

        if (args.length == 2) {
            Player t = Bukkit.getPlayer(args[1]);
            m.setGamemodeOthers(p, t, m.decideGamemode(args[0]));
            return true;
        }
        return true;
    }
}
