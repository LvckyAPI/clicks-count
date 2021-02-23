import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(new Listener1(), this);
    }
}
