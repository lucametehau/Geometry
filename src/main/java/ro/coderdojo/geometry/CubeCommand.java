package ro.coderdojo.geometry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CubeCommand implements CommandExecutor {

    JavaPlugin plugin;

    public CubeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            Player player = (Player) commandSender;
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();
            for (int x1 = 1; x1 < Integer.valueOf(args[0]); x1++) {
                for (int y1 = 1; y1 < Integer.valueOf(args[1]); y1++) {
                    for (int z1 = 1; z1 < Integer.valueOf(args[2]); z1++) {
                        Location loc = new Location(player.getLocation().getWorld(), x + x1 + 10, y + y1 + 10, z + z1);
                        loc.getBlock().setType(player.getInventory().getItemInMainHand().getType());
                    }
                }
            }
        });

        commandSender.sendMessage("Ai reușit să creezi o comandă în Minecraft cu Spigot");
        return true;
    }
}
