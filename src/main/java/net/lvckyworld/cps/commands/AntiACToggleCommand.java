package net.lvckyworld.cps.commands;

import com.rylinaux.plugman.util.PluginUtil;
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
public class AntiACToggleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration cfg = Main.getPlugin().getConfig();
        boolean AntiAC = cfg.getBoolean("Config.AntiAC");
        String prefix = cfg.getString("Main.Prefix") + " ";
        String lang = cfg.getString("Main.Language");


        String toggleFalse;
        String toggleTrue;
        String noperms;
        String argError;
        String antiAC_Status;
        if (lang.equalsIgnoreCase("de")) {
            toggleFalse = prefix + "§bAntiAC§c deaktiviert";
            toggleTrue = prefix + "§bAntiAC§a aktiviert";
            noperms = prefix + "§cDafür hast du keine Rechte";
            argError = prefix + "§cMache§e /antiac toggle";
            if (AntiAC) {
                antiAC_Status = prefix + "§bAntiAC ist momentan§a aktiv";
            } else {
                antiAC_Status = prefix + "§bAntiAC ist momentan §nicht aktiv";
            }
        } else if (lang.equalsIgnoreCase("en")) {
            toggleFalse = prefix + "§bAntiAC§c deactivated";
            toggleTrue = prefix + "§bAntiAC§a activated";
            noperms = prefix + "§cYou don't have enough permissions";
            argError = prefix + "§cUsage§e /antiac toggle";
            if (AntiAC) {
                antiAC_Status = prefix + "§bAntiAC is currently§a active";
            } else {
                antiAC_Status = prefix + "§bAntiAC is currently§c not active";
            }
        } else {
            toggleFalse = prefix + "§cCONFIG ERROR";
            toggleTrue = prefix + "§cCONFIG ERROR";
            noperms = prefix + "§cCONFIG ERROR";
            argError = prefix + "§cCONFIG ERROR";
            if (AntiAC) {
                antiAC_Status = prefix + "§cCONFIG ERROR";
            } else {
                antiAC_Status = prefix + "§cCONFIG ERROR";
            }
        }

        Player p = (Player) sender;
        if (args.length == 1) {
            if (p.hasPermission("system.clicks.*")) {
                if (args[0].equalsIgnoreCase("toggle")) {
                    if (AntiAC) {
                        cfg.set("Config.AntiAC", false);
                        Main.getPlugin().saveConfig();
                        p.sendMessage(toggleFalse);
                    } else {
                        cfg.set("Config.AntiAC", true);
                        Main.getPlugin().saveConfig();
                        p.sendMessage(toggleTrue);
                    }
                    PluginUtil.reload(Bukkit.getPluginManager().getPlugin("LvckyCPS"));

                } else {
                    p.sendMessage(argError);
                }
            } else {
                p.hasPermission(noperms);
            }
        } else if (args.length == 0) {
            p.sendMessage(antiAC_Status);
        } else {
            p.sendMessage(argError);
        }
        return false;
    }
}
