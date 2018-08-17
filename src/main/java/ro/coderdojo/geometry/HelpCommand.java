/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.coderdojo.geometry;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *public class HelpCommand implements CommandExecutor {

 * @author LMM
 */
public class HelpCommand implements CommandExecutor {
    
    @Override
    
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = (Player) commandSender;
        player.sendMessage("Salut!\nComenzile suportate sunt:\n");
        player.sendMessage("-cube\n-sphere\n-cylinder\n-prism\n-pyramide\n-infinitycolumn\n");
        return true;
    }
    
}
