package sabastians.global.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import sabastians.global.init.ItemInit;

public class MaterialsTab extends CreativeTabs {
	
	public MaterialsTab(String label) {
		super(label);
	}
	
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.COPPER_INGOT);
	}
}