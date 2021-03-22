package net.lvckyworld.cps.main;

import net.lvckyworld.cps.commands.AntiACToggleCommand;
import net.lvckyworld.cps.commands.ClicksCommand;
import net.lvckyworld.cps.commands.LanguageCommand;
import net.lvckyworld.cps.listener.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {


    public static ArrayList<String> getPenis() {
        return penis;
    }

    public static ArrayList<String> penis = new ArrayList<>();


    public static Main getPlugin() {
        return plugin;
    }



/*
    FileConfiguration cfg = Main.getPlugin().getConfig();
    String prefix = cfg.getString("Main.Prefix") + " ";
    String lang = cfg.getString("Main.Language");

    if (lang.equalsIgnoreCase("de")) {

    } else if (lang.equalsIgnoreCase("en")) {

    }else {

    }
  */

    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();
        this.getServer().getPluginManager().registerEvents(new ClickListener(), this);

        getCommand("cps-toggle").setExecutor(new ClicksCommand());
        getCommand("lang").setExecutor(new LanguageCommand());
        getCommand("antiac").setExecutor(new AntiACToggleCommand());
    }


    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
