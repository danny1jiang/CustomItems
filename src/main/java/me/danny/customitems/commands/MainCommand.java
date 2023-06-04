package me.danny.customitems.commands;

import me.danny.customitems.utils.ItemTemplate;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("You can only execute this command as a player!");
        }
        Player p = (Player) sender;
        switch (args[0]) {
            case "get": {
                HashMap<String, ItemStack> items = ItemTemplate.itemList;
                if(items.containsKey(args[1])) {
                    p.getInventory().addItem(items.get(args[1]));
                    p.sendMessage(ChatColor.GREEN + "You have been given the item!");
                } else {
                    p.sendMessage(ChatColor.RED + "This item does not exist!");
                }
            }
        }
        return true;
    }

}
