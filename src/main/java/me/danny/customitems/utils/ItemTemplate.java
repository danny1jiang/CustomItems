package me.danny.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ItemTemplate {

    public static HashMap<String, ItemStack> itemList = new HashMap<>();

    //Adds an item to itemList
    public ItemStack addItem(String name, Material mat, String displayName, String description, String rarity) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(getRarityString(rarity) + displayName);
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Rarity: " + getRarityString(rarity) + rarity);
        lore.add("");
        lore.add(ChatColor.GRAY + description);
        meta.setLore(lore);

        item.setItemMeta(meta);
        itemList.put(name, item);
        return item;
    }

    public ItemStack addItem(String name, Material mat, String displayName, String description, String rarity, ConfigurationSection attributes) {
        ItemStack item = addItem(name, mat, displayName, description, rarity);
        ItemMeta meta = item.getItemMeta();
        for(String attributeName : attributes.getKeys(false)) {
            ConfigurationSection attributeSection = attributes.getConfigurationSection(attributeName);
            Attribute attribute = Attribute.valueOf(attributeName);
            double amount = attributeSection.getDouble("amount");
            String slot = attributeSection.getString("slot");
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), attributeName, amount, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(slot));
            meta.addAttributeModifier(attribute, modifier);
        }
        item.setItemMeta(meta);
        itemList.put(name, item);
        return item;
    }

    //Returns rarity with color
    private ChatColor getRarityString(String rarity) {
        switch(rarity) {
            case "Common": {
                return ChatColor.WHITE;
            }
            case "Rare": {
                return ChatColor.GREEN;
            }
            case "Epic": {
                return ChatColor.AQUA;
            }
            case "Legendary": {
                return ChatColor.GOLD;
            }
        }
        return null;
    }

}
