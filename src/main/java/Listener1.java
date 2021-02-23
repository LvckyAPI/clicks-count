import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listener1 implements Listener {
    public static int clicks = 0;
    public static int schedule;

    @EventHandler
    public void onClick(PlayerInteractEvent e){

        int ping = (((CraftPlayer)Bukkit.getPlayer("SatophdieLegende ")).getHandle()).ping;
        clicks++;
        schedule = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()){
                    all.getPlayer().sendMessage("§7[§3CPS§7] Klicks von §aStophdieLegende §8» §b" + clicks + " §7︳ " + "§a" + ping + "ms");
                }

                clicks = 0;
                Bukkit.getScheduler().cancelAllTasks();
            }
        },20);


    }
}
