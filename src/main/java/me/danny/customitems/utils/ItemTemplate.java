package me.danny.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemTemplate {

    public static HashMap<String, ItemStack> itemList = new HashMap<>();

    //Adds an item to itemList
    public void addItem(String name, Material mat, String displayName, String description, String rarity) {
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
