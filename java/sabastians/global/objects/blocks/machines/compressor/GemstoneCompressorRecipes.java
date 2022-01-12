package sabastians.global.objects.blocks.machines.compressor;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import sabastians.global.init.ItemInit;

public class GemstoneCompressorRecipes {
	private static final GemstoneCompressorRecipes INSTANCE = new GemstoneCompressorRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	private final Map<ItemStack, Float> extraTimeList = Maps.<ItemStack, Float>newHashMap();
	
	public static GemstoneCompressorRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private GemstoneCompressorRecipes() 
	{
		addCompressorRecipe(new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Items.EMERALD), new ItemStack(ItemInit.MONSTERMAN_INGOT), 10.0F, 90);
		//addCompressorRecipe(new ItemStack(Items.EMERALD), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(ItemInit.MONSTERMAN_INGOT), 10.0F, 10);
	}

	
	public void addCompressorRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience, int extraTime) 
	{
		if(getCompressorResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
		this.extraTimeList.put(result, Float.valueOf(extraTime));
	}
	
	public ItemStack getCompressorResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	public int getCompressorExtraTime(ItemStack stack) {
		for (Entry<ItemStack, Float> entry : this.extraTimeList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).intValue();
			}
		}
		return 0;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getCompressorExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}