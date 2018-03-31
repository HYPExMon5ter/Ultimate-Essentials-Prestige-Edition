package net.hypexmon5ter.uepe.methods;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Misc {

    public GameMode decideGamemode(String g) {
        if (g.equalsIgnoreCase("survival") || g.equalsIgnoreCase("0") || g.equalsIgnoreCase("surv") || g.equalsIgnoreCase("s")) {
            return GameMode.SURVIVAL;
        }
        else if (g.equalsIgnoreCase("adventure") || g.equalsIgnoreCase("adv") || g.equalsIgnoreCase("2") || g.equalsIgnoreCase("a")) {
            return GameMode.ADVENTURE;
        }
        else if (g.equalsIgnoreCase("creative") || g.equalsIgnoreCase("cre") || g.equalsIgnoreCase("1") || g.equalsIgnoreCase("c")){
            return GameMode.CREATIVE;
        }
        else if (g.equalsIgnoreCase("spectator") || g.equalsIgnoreCase("spec") || g.equalsIgnoreCase("3") || g.equalsIgnoreCase("sp")){
            return GameMode.SPECTATOR;
        } else {
            return null;
        }
    }

    public void setGamemode(Player s, GameMode g) {
        if (!(s.hasPermission("ue.gamemode"))) {
            s.sendMessage("Perm message");
            return;
        }

        if (g == null) {
            s.sendMessage("That is not a valid gamemode.");
            return;
        }

        s.setGameMode(g);
        s.sendMessage("You succesfully changed your gamemode to " + g.toString() + ".");
    }

    public void setGamemodeOthers(Player s, Player t, GameMode g) {
        if (s == t) {
            s.sendMessage("Why would you specify yourself?");
            return;
        }

        if (!(s.hasPermission("ue.gamemode.others"))) {
            s.sendMessage("Perm message");
            return;
        }

        if (g == null) {
            s.sendMessage("That is not a valid gamemode.");
            return;
        }

        t.setGameMode(g);
        s.sendMessage("Successfully set the gamemode of " + t.getName() + " to " + g.toString() + ".");
        t.sendMessage(s.getName() + " has set your gamemode to " + g.toString() + ".");
    }

}
