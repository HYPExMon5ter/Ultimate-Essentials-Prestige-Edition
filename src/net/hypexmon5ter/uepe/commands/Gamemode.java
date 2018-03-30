package net.hypexmon5ter.uepe.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Gamemode implements CommandExecutor {
    private String permissionMsg = "You do not have permission to use this command.";

    public void setGamemode(Player p, String g, Player a) {
        if (g.equalsIgnoreCase("survival") || g.equalsIgnoreCase("0") || g.equalsIgnoreCase("surv") || g.equalsIgnoreCase("s")) {
            p.setGameMode(GameMode.SURVIVAL);
        }
        else if (g.equalsIgnoreCase("adventure") || g.equalsIgnoreCase("adv") || g.equalsIgnoreCase("2") || g.equalsIgnoreCase("a")) {
            p.setGameMode(GameMode.ADVENTURE);
        }
        else if (g.equalsIgnoreCase("creative") || g.equalsIgnoreCase("cre") || g.equalsIgnoreCase("1") || g.equalsIgnoreCase("c")){
            p.setGameMode(GameMode.CREATIVE);
        }
        else if (g.equalsIgnoreCase("spectator") || g.equalsIgnoreCase("spec") || g.equalsIgnoreCase("3") || g.equalsIgnoreCase("sp")){
            p.setGameMode(GameMode.SPECTATOR);
        }
        String gm = p.getGameMode().name();
        if (p == a) {
            p.sendMessage("Your gamemode has been set to " + gm);
        }
        else {
            a.sendMessage("You changed " + p + "'s gamemode to " + gm);
            p.sendMessage("Your gamemode has been set to " + gm);
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (label == "gamemode" || label == "gm") {
            if(args[0] != null) {
                if(args[1] != null) {
                    Player target = getServer().getPlayerExact(args[1]);
                    if (target != player){
                        if(player.hasPermission("ue.gamemode.others")) {

                        }
                    }
                        else {
                            player.sendMessage(permissionMsg);
                        }
                }
            }
        }

        
        return true;
    }
}
