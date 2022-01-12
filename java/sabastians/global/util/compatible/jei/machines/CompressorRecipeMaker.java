package sabastians.global.util.compatible.jei.machines;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import sabastians.global.objects.blocks.machines.compressor.GemstoneCompressorRecipes;

public class CompressorRecipeMaker {
	
	public static List<CompressorRecipe> getRecipes(IJeiHelpers helpers){
		IStackHelper stackHelper = helpers.getStackHelper();
		GemstoneCompressorRecipes instance = GemstoneCompressorRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<CompressorRecipe> jeiRecipes = Lists.newArrayList();
		
		for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
			for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getKey();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				List<ItemStack> inputs2 = Lists.newArrayList(input2, input1);
				CompressorRecipe recipe = new CompressorRecipe(inputs, output);
				jeiRecipes.add(recipe);
				recipe = new CompressorRecipe(inputs2, output);
				jeiRecipes.add(recipe);
			}
		}
		
		return jeiRecipes;
	}
}