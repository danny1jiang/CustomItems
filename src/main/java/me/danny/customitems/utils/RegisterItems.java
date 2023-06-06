package me.danny.customitems.utils;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class RegisterItems {

    public void registerItems(FileConfiguration config) {

        String name = null;
        String display = null;
        String description = null;
        Material material = null;
        String rarity = null;
        ItemTemplate template = new ItemTemplate();
        ConfigurationSection attributes = null;
        ConfigurationSection item;

        for(String itemName : config.getConfigurationSection("items").getKeys(false)) {
            item = config.getConfigurationSection("items." + itemName);
            name = itemName;
            display = item.getString("display");
            description = item.getString("description");
            material = Material.valueOf(item.getString("material").toUpperCase());
            rarity = item.getString("rarity");
            attributes = item.getConfigurationSection("attributes");
            if(attributes.getKeys(false) == null) {
                template.addItem(name, material, display, description, rarity);
            } else {
                template.addItem(name, material, display, description, rarity, attributes);
            }
        }

    }

}
