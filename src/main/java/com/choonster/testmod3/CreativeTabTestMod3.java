package com.choonster.testmod3;

import com.choonster.testmod3.util.SwordUpgrades;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class CreativeTabTestMod3 extends CreativeTabs {
	private final ItemStack sword;

	public CreativeTabTestMod3() {
		super(TestMod3.MODID);
		sword = SwordUpgrades.upgradeSword((ItemSword) Items.stone_sword);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		return Items.stone_sword;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void displayAllRelevantItems(List<ItemStack> items) {
		items.add(sword.copy());
		super.displayAllRelevantItems(items);
	}
}
