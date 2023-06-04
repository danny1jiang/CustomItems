package me.danny.customitems.commands;

import me.danny.customitems.utils.ItemTemplate;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MainTabCompleter implements TabCompleter {

    List<String> arguments = new ArrayList<>();
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> result = new ArrayList<>();
        arguments.add("get");
        //Checks how many args there are
        switch (args.length) {
            case 1: {
                for (String arg : arguments) {
                    if(startsWith(args[0], arg)) {
                        result.add(arg);
                    }
                }
                return result;
            }
            case 2: {
                //Checks what arg it is
                Bukkit.getLogger().info(args[0]);
                switch(args[0]) {
                    case "get": {
                        for(String name : ItemTemplate.itemList.keySet()) {
                            Bukkit.getLogger().info(name);
                            if(startsWith(args[1], name)) {
                                result.add(name);
                            }
                        }
                    }
                }
                return result;
            }
        }
        return null;
    }

    //Checks if text starts with typed
    private boolean startsWith(String typed, String text) {
        if (text.toLowerCase().startsWith(typed.toLowerCase())) {
            return true;
        }
        return false;
    }
}
