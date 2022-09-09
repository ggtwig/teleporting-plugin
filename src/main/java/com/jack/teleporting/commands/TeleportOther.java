package com.jack.teleporting.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportOther implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 2 && sender.hasPermission("teleporting.tpother")) {
            Player playerToSend = Bukkit.getPlayer(args[0]);
            Player target = Bukkit.getPlayer(args[1]);

            try {
                playerToSend.teleport(target.getLocation());
            } catch (NullPointerException e) {
                player.sendMessage("§cPlayer does not exist!");
            }
        }
        return true;
    }
}
