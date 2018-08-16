/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.coderdojo.geometry;

import static java.lang.Math.sqrt;
import org.bukkit.Location;
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
public class CylinderCommand implements CommandExecutor {
    JavaPlugin plugin;

    public CylinderCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        
        new BukkitRunnable() {
            public void run() {
                Player player = (Player) commandSender;
                final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(Integer.valueOf(args[0]));
            
                Location inFrontLoc = player.getLocation().add(fb_direction);
            
                int x = Integer.valueOf(args[0]);
                int y = Integer.valueOf(args[1]);
            
                for(int k = 1; k <= y; k++) {
                    for(int i = -x; i <= x; i++) {
                        for(int j = -x; j <= x; j++) {
                            if(sqrt(i * i + j * j) <= x) {
                                
                                Block block = inFrontLoc.clone().add(i, k, j).getBlock();
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