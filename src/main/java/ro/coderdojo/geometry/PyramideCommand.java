/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.coderdojo.geometry;

import java.util.Random;
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

/**
 *
 * @author andre
 */
public class PyramideCommand implements CommandExecutor {

    JavaPlugin plugin;

    public PyramideCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        new BukkitRunnable() {
            public void run() {
                Player player = (Player) commandSender;
                final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(Integer.valueOf(args[0]));

                Location inFrontLoc = player.getLocation().add(fb_direction);
                for (int z = 1; z < Integer.valueOf(args[0]); z++) {

                    for (int y = 1 + z; y < Integer.valueOf(args[0]) - z; y++) {

                        for (int x = 1 + z; x < Integer.valueOf(args[0]) - z; x++) {
                            int rndIdx;
                            if (args.length > 1 && "r".equals(args[1])) {
                                Material[] all = Material.values();
                                do {
                                    Random rnd = new Random();
                                    rndIdx = rnd.nextInt(all.length);
                                    if (all[rndIdx].isBlock() && all[rndIdx] != Material.WATER && all[rndIdx] != Material.LAVA) {
                                        break;
                                    }
                                } while (true);

                                Block block = inFrontLoc.clone().add(x, z, y).getBlock();
                                block.setType(all[rndIdx]);
                            } else {
                                Block block = inFrontLoc.clone().add(x, z, y).getBlock();
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
