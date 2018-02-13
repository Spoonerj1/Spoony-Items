package com.chrismin13.vanillaadditions.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.chrismin13.additionsapi.events.item.CustomItemBlockBreakEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;

public class BlockBreakListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCustomItemBlockBreak(CustomItemBlockBreakEvent event) {
		if (event.isCancelled())
			return;
		CustomItem cItem = event.getCustomItem();
		CustomItemStack cStack = event.getCustomItemStack();
		BlockBreakEvent breakEvent = event.getBlockBreakEvent();
		Player player = breakEvent.getPlayer();
		Block block = breakEvent.getBlock();
		if (cItem instanceof DoubleAxeAbilities
				&& (block.getType().equals(Material.LOG) || block.getType().equals(Material.LOG_2))) {
			((DoubleAxeAbilities) cItem).chopTree(player, block, cStack);
		} else if (cItem instanceof SickleAbilities) {
			((SickleAbilities) cItem).onUse(cStack, block, player);
		}
	}

}