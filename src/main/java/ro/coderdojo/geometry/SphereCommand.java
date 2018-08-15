package ro.coderdojo.geometry;

import static java.lang.Math.sqrt;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SphereCommand implements CommandExecutor {

    JavaPlugin plugin;

    public SphereCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player player;
        player = (Player) commandSender;

        final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(Integer.valueOf(args[0]));
        Location centre = player.getLocation().add(fb_direction);
                
        new BukkitRunnable() {
            public void run() {
                int x = Integer.valueOf(args[0]);
                for (int i = -x; i <= x; i++) {
                    for (int j = -x; j <= x; j++) {
                        for (int k = -x; k <= x; k++) {
                            if (sqrt(i * i + j * j + k * k) <= x) {
                                Location loc = centre.clone().add(i, j, k);
                                loc.getBlock().setType(player.getInventory().getItemInMainHand().getType());
                            }
                        }
                    }
                }
            }
        }.runTask(plugin);
        return true;
    }
}
