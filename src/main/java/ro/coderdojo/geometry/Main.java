package ro.coderdojo.geometry;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import ro.coderdojo.geometry.CoderDojoCommand;
import ro.coderdojo.geometry.EventsListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		
		
		this.getCommand("CoderDojo").setExecutor(new CoderDojoCommand());
                this.getCommand("cube").setExecutor(new CoderDojoCommand());
    }

}
