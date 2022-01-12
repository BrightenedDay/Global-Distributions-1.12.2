package sabastians.global.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sabastians.global.init.BlockInit;

public class OresTab extends CreativeTabs {
	
	public OresTab(String label) {
		super(label);
		this.setBackgroundImageName("items.png");
	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(BlockInit.ORE_OVERWORLD));
	}
}