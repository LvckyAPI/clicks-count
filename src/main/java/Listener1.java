import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class Listener1 implements Listener {
    public static int clicks = 0;
    public static int schedule;

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player t = e.getPlayer();

        int ping = (((CraftPlayer)Bukkit.getPlayer(e.getPlayer().getName())).getHandle()).ping;
        clicks++;

            schedule = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
                @Override
                public void run() {

                    for (String spielers : Main.penis) {

                        Player p = Bukkit.getPlayer(spielers);

                        

                        p.getPlayer().sendMessage("§7[§3CPS§7] Klicks von §a" + e.getPlayer().getName() + " §8» §b" + clicks + " §7︳ " + "§a" + ping + "ms");

                    }



                    clicks = 0;
                    Bukkit.getScheduler().cancelAllTasks();
                }
            },20);







    }
}
