package me.danny.customitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public class RegisterItems {

    public void registerItems() {

        ItemTemplate template = new ItemTemplate();
        template.addItem("club", Material.WOODEN_SHOVEL, "Club", "A plain, wooden club", "Common");

    }

}
