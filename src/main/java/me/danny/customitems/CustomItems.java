package me.danny.customitems;

import me.danny.customitems.commands.MainCommand;
import me.danny.customitems.commands.MainTabCompleter;
import me.danny.customitems.utils.RegisterItems;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        RegisterItems register = new RegisterItems(); //Constructors for custom items

        Bukkit.getLogger().info("CustomItems has been enabled");
        registerCommands();
        register.registerItems();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        this.getCommand("customitems").setExecutor(new MainCommand());
        this.getCommand("customitems").setTabCompleter(new MainTabCompleter());
    }

}
