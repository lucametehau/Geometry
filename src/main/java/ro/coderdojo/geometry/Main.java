package ro.coderdojo.geometry;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new EventsListener(), this);

        this.getCommand("cube").setExecutor(new CubeCommand(this));

        this.getCommand("Sphere").setExecutor(new SphereCommand(this));

        this.getCommand("cylinder").setExecutor(new CylinderCommand(this));
        
        this.getCommand("prism").setExecutor(new PrismCommand(this));
        
        this.getCommand("infinitycolumn").setExecutor(new InfinityColumnCommand(this));
        
        this.getCommand("pyramide").setExecutor(new PyramideCommand(this));

        this.getCommand("help").setExecutor(new HelpCommand());
    }

}
