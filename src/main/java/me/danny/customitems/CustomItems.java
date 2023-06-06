package me.danny.customitems;

import me.danny.customitems.commands.MainCommand;
import me.danny.customitems.commands.MainTabCompleter;
import me.danny.customitems.utils.RegisterItems;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomItems extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("CustomItems has been enabled");
        registerCommands();
        registerConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerConfig() {
        config.options().copyDefaults(true);
        saveConfig();
        RegisterItems register = new RegisterItems(); //Constructors for custom items
        register.registerItems(config);
    }

    private void registerCommands() {
        this.getCommand("customitems").setExecutor(new MainCommand());
        this.getCommand("customitems").setTabCompleter(new MainTabCompleter());
    }

}
