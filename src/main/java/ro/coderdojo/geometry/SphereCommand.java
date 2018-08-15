package ro.coderdojo.geometry;

import static java.lang.Math.sqrt;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class SphereCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
                Player player;
                player = (Player) commandSender;
               
               final Vector fb_direction = player.getEyeLocation().getDirection().normalize().multiply(3);
               Location inFrontLoc = player.getLocation().add(fb_direction);
               Location centre = inFrontLoc.add(100, 100, 0);
               for(int i = -100; i <= 100; i++) {
                    for(int j = -100; j <= 100; j++) {
                        for(int k = -100; k <= 100; k++) {
                            if(sqrt(i * i + j * j + k * k) <= 100) {
                                Location loc = centre.clone().add(i, j, k);
                                loc.getBlock().setType(player.getInventory().getItemInMainHand().getType());
                            }
                        }
                    }
                }
		return true;
	}
}
