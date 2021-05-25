package net.lvckyworld.cps.commands;

import net.lvckyworld.cps.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * ©2016-2021 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/

public class ClicksCommand implements CommandExecutor {


    FileConfiguration cfg = Main.getPlugin().getConfig();
    String prefix = cfg.getString("Main.Prefix") + " ";
    String lang = cfg.getString("Main.Language");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        String off;
        String on;
        if (lang.equalsIgnoreCase("de")) {
            on = "§bDir werden§a nun§b die Clicks aller Spieler angezeigt.";
            off = "§bDir werden nun§c nicht§b mehr die Clicks aller Spieler angezeigt.";
        } else if (lang.equalsIgnoreCase("en")) {
            on = "§bNow you§a can see§b the clicks of other Players";
            off = "§bNow you§c can't see§b the clicks of other Players";
        } else {
            on = "§cCONFIG ERROR";
            off = "§cCONFIG ERROR";

            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage("§eDeutsch");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4Config Fehler");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4Bitte überprüfe die Config Datei");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4andernfalls lösche die config und lasse sie neu erstellen");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage("§cEnglish");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4Config Error");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4Please Check the Config-File");
            Bukkit.getConsoleSender().sendMessage(prefix + "§4or delete the config-file and let it generate new");
        }

        FileConfiguration cfg = Main.getPlugin().getConfig();
        String prefix = cfg.getString("Main.Prefix") + " ";

        if (p.hasPermission("system.clicks") || p.hasPermission("system.clicks.*")) {

            if (Main.getPenis().contains(p.getName())) {
                Main.getPenis().remove(p.getName());
                p.sendMessage(prefix + off);
            } else {
                Main.getPenis().add(p.getName());
                p.sendMessage(prefix + on);
            }


        }

        return false;
    }
}
