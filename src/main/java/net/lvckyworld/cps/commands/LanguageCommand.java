package net.lvckyworld.cps.commands;

import com.rylinaux.plugman.util.PluginUtil;
import net.lvckyworld.cps.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;

/**
 * ©2016-2021 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class LanguageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration cfg = Main.getPlugin().getConfig();
        boolean AntiAC = cfg.getBoolean("Config.AntiAC");
        String prefix = cfg.getString("Main.Prefix") + " ";
        String lang = cfg.getString("Main.Language");

        String currentLang;
        String noperms;
        String argError;
        if (lang.equalsIgnoreCase("de")) {
            currentLang = prefix + "§edeutsch";
            noperms = prefix + "§cDafür hast du keine Rechte";
            argError = prefix + "§cMache§e /lang <de|en>";
        } else if (lang.equalsIgnoreCase("en")) {
            currentLang = prefix + "§eenglish";
            noperms = prefix + "§cYou don't have enough permissions";
            argError = prefix + "§cUsage§e /lang <de|en>";
        } else {
            currentLang = prefix + "§cCONFIG ERROR";
            noperms = prefix + "§cCONFIG ERROR";
            argError = prefix + "§cCONFIG ERROR";
        }

        Player p = (Player) sender;
        if (args.length == 1) {
            if (p.hasPermission("system.clicks.*")) {
                if (args[0].equalsIgnoreCase("de")) {
                    cfg.set("Main.Language", "de");
                    Main.getPlugin().saveConfig();
                    p.sendMessage(prefix + "§bDie Sprache ist nun deutsch");
                    PluginUtil.reload(Bukkit.getPluginManager().getPlugin("LvckyCPS"));
                } else if (args[0].equalsIgnoreCase("en")) {
                    cfg.set("Main.Language", "en");
                    Main.getPlugin().saveConfig();
                    p.sendMessage(prefix + "§bThe language is now English");
                    PluginUtil.reload(Bukkit.getPluginManager().getPlugin("LvckyCPS"));
                } else {
                    p.sendMessage(argError);
                }
            } else {
                p.hasPermission(noperms);
            }
        } else if (args.length == 0) {
            p.sendMessage(prefix + "§bDie aktuelle Sprache ist: " + currentLang);
            p.sendMessage(prefix + "§bThe current language is: " + currentLang);
        } else {
            p.sendMessage(argError);
        }

        return false;
    }
}
