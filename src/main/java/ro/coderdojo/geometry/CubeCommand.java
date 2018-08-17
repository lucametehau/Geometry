package ro.coderdojo.geometry;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
                final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(Integer.valueOf(args[0])+3);

                Location inFrontLoc = player.getLocation().add(fb_direction);
                for (int x = 1; x < Integer.valueOf(args[0]); x++) {
                    for (int y = 1; y < Integer.valueOf(args[1]); y++) {
                        for (int z = 1; z < Integer.valueOf(args[2]); z++) {
                            int rndIdx;
                            if (args.length > 3 && "r".equals(args[3])) {
                                Material[] all = Material.values();
                                do {
                                    Random rnd = new Random();
                                    rndIdx = rnd.nextInt(all.length);
                                    if (all[rndIdx].isBlock()) {
                                        break;
                                    }
                                } while (true);

                                Block block = inFrontLoc.clone().add(x, y, z).getBlock();
                                block.setType(all[rndIdx]);
                            } else {
                                Block block = inFrontLoc.clone().add(x, y, z).getBlock();
                                block.setType(player.getInventory().getItemInMainHand().getType());
                                block.setData(player.getInventory().getItemInMainHand().getData().getData());
                            }
                        }
                    }
                }
            }
        }.runTask(plugin);

        return true;
    }
}
