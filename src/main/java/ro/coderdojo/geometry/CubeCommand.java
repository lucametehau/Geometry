package ro.coderdojo.geometry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CubeCommand implements CommandExecutor {

    JavaPlugin plugin;

    public CubeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        new BukkitRunnable() {
            public void run() {
            Player player = (Player) commandSender;

            final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(5);
            Location inFrontLoc = player.getLocation().add(fb_direction);

            int x = inFrontLoc.getBlockX();
            int y = inFrontLoc.getBlockY();
            int z = inFrontLoc.getBlockZ();
            for (int x1 = 1; x1 < Integer.valueOf(args[0]); x1++) {
                for (int y1 = 1; y1 < Integer.valueOf(args[1]); y1++) {
                    for (int z1 = 1; z1 < Integer.valueOf(args[2]); z1++) {
                        Location loc = new Location(player.getLocation().getWorld(), x + x1 + 10, y + y1 + 10, z + z1);
                        loc.getBlock().setType(player.getInventory().getItemInMainHand().getType());
                    }
                }
            }
        }
            }.runTask(plugin);

        commandSender.sendMessage("Ai reușit să creezi o comandă în Minecraft cu Spigot");
        return true;
    }
}
