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
 * @author LMM
 */
public class InfinityColumnCommand implements CommandExecutor {

    JavaPlugin plugin;

    public InfinityColumnCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        new BukkitRunnable() {
            public void run() {
                Player player = (Player) commandSender;
                final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply( Integer.valueOf(args[0])+3);

                Location inFrontLoc = player.getLocation().add(fb_direction);

                int x = Integer.valueOf(args[0]);
                int y = Integer.valueOf(args[1]);

                for (int k = 1; k <= y; k++) {
                    for (int i = 1; i <= x; i++) {
                        for (int j = -(i - 1); j <= i - 1; j++) {
                            for (int l = -(i - 1); l <= i - 1; l++) {
                                int rndIdx;
                                if (args.length > 2 && "r".equals(args[2])) {
                                    Material[] all = Material.values();
                                    do {
                                        Random rnd = new Random();
                                        rndIdx = rnd.nextInt(all.length);
                                        if (all[rndIdx].isBlock() && all[rndIdx] != Material.WATER && all[rndIdx] != Material.LAVA) {
                                            break;
                                        }
                                    } while (true);

                                    Block block = inFrontLoc.clone().add(i, k, j).getBlock();
                                    block.setType(all[rndIdx]);
                                } else {
                                    Block block = inFrontLoc.clone().add(j, (k - 1) * (2 * x - 1) + i, l).getBlock();
                                    block.setType(player.getInventory().getItemInMainHand().getType());
                                    block.setData(player.getInventory().getItemInMainHand().getData().getData());
                                }
                            }
                        }
                    }
                    for (int i = x + 1; i <= 2 * x - 1; i++) {
                        for (int j = -(2 * x - i - 1); j <= 2 * x - i - 1; j++) {
                            for (int l = -(2 * x - i - 1); l <= 2 * x - i - 1; l++) {
                                int rndIdx;
                                if (args.length > 2 && "r".equals(args[2])) {
                                    Material[] all = Material.values();
                                    do {
                                        Random rnd = new Random();
                                        rndIdx = rnd.nextInt(all.length);
                                        if (all[rndIdx].isBlock() && all[rndIdx] != Material.WATER && all[rndIdx] != Material.LAVA) {
                                            break;
                                        }
                                    } while (true);

                                    Block block = inFrontLoc.clone().add(i, k, j).getBlock();
                                    block.setType(all[rndIdx]);
                                } else {
                                    Block block = inFrontLoc.clone().add(j, (k - 1) * (2 * x - 1) + i, l).getBlock();
                                    block.setType(player.getInventory().getItemInMainHand().getType());
                                    block.setData(player.getInventory().getItemInMainHand().getData().getData());
                                }
                            }
                        }
                    }
                }
            }
        }.runTask(plugin);

        return true;
    }
}
