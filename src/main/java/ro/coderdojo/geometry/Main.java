package ro.coderdojo.geometry;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
		//Register Event Listeners
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		
		//Register Command Executors
		this.getCommand("Sphere").setExecutor(new CoderDojoCommand());
    }

}
