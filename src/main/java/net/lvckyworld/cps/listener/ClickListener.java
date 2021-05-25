package net.lvckyworld.cps.listener;

import net.lvckyworld.cps.main.Main;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class ClickListener implements Listener {
    FileConfiguration cfg = Main.getPlugin().getConfig();

    String prefix = cfg.getString("Main.Prefix") + " ";
    String lang = cfg.getString("Main.Language");
    Boolean AntiAC = cfg.getBoolean("Config.AntiAC");

    public static long clicks = 0;
    public static int schedule;

    @EventHandler
    public void onLeave(PlayerKickEvent e){
        Bukkit.getScheduler().cancelAllTasks();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player t = e.getPlayer();


        int ping = (((CraftPlayer) Bukkit.getPlayer(e.getPlayer().getName())).getHandle()).ping;
        clicks++;
        schedule = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
            @Override
            public void run() {

                for (String spielers : Main.getPenis()) {
                    Player p = Bukkit.getPlayer(spielers);
                    String clickstring;
                    if (!(clicks >= 20)) {
                        clickstring = "§b" + String.valueOf(clicks);
                    } else {
                        clickstring = "§c§l" + String.valueOf(clicks);
                    }
                    String klicksmsg;
                    if (lang.equalsIgnoreCase("de")) {
                        klicksmsg = "Klicks von §a" + e.getPlayer().getName() + " §8» §b" + clickstring + " §7︳ " + "§a" + ping + "ms";
                    } else if (lang.equalsIgnoreCase("en")) {
                        klicksmsg = "Clicks of §a" + e.getPlayer().getName() + " §8» §b" + clickstring + " §7︳ " + "§a" + ping + "ms";
                    } else {
                        klicksmsg = "§cCONFIG ERROR";
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
                    if (AntiAC) {

                        p.getPlayer().sendMessage(prefix + klicksmsg);


                        if (clicks >= 56) {
                            t.kickPlayer(prefix + "§cAutoClicker is not allowed");
                            clicks = 0;
                            return;
                        }
                    }

                }
                clicks = 0;
                Bukkit.getScheduler().cancelAllTasks();
            }
        }, 20L);


    }
}
