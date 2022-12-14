package com.jack.teleporting.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        if (sender.hasPermission("teleporting.all")) {
            Player player = (Player) sender;
            if (Bukkit.getServer().getOnlinePlayers().size() == 1) {
                player.sendMessage("§aNo other players are online right now!");
            } else if (Bukkit.getServer().getOnlinePlayers().size() > 1) {
                int numberOfPlayers = 0;
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.teleport(player.getLocation());
                    numberOfPlayers++;
                }
                player.sendMessage("§eTeleported all " + (numberOfPlayers - 1) + " players to you!");
            }
        }
        return true;
    }
}
