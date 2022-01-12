package sabastians.global.objects.blocks.machines.compressor.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import sabastians.global.objects.blocks.machines.compressor.TileEntityGemstoneCompressor;

public class SlotGemstoneCompressorFuel extends Slot {
	
	public SlotGemstoneCompressorFuel(IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityGemstoneCompressor.isItemFuel(stack);
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}
}