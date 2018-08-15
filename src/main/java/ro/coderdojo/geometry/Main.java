package ro.coderdojo.geometry;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		
                this.getCommand("cube").setExecutor(new CubeCommand(this));

		this.getCommand("Sphere").setExecutor(new SphereCommand(this));

    }

}
