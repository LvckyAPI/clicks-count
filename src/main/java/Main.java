import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {



    public static ArrayList<String> penis = new ArrayList<>();




    public static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new Listener1(), this);

        getCommand("cps-toggle").setExecutor(new ClicksCommand());
    }
}
