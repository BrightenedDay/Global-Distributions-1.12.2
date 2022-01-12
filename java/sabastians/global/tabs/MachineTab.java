package sabastians.global.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sabastians.global.init.BlockInit;

public class MachineTab extends CreativeTabs {
	
	public MachineTab(String label) {
		super(label);
	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(BlockInit.GEMSTONE_COMPRESSOR));
	}
}