package sabastians.global.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import sabastians.global.Main;
import sabastians.global.init.ItemInit;
import sabastians.global.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel {
	
	public ItemBase(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}