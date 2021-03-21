import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * ©2016-2021 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/

public class ClicksCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("system.clicks")) {

            for (String spielers : Main.penis) {
                if (!(spielers.equalsIgnoreCase(p.getName()))) {
                    Main.penis.add(p.getName());
                    p.sendMessage("§7[§3CPS§7] §bDir werden§a nun§b die Clicks aller Spieler angezeigt.");
                } else {
                    Main.penis.remove(p.getName());
                    p.sendMessage("§7[§3CPS§7] §bDir werden nun§c nicht§b mehr die Clicks aller Spieler angezeigt.");
                }

            }

        }

        return false;
    }
}
