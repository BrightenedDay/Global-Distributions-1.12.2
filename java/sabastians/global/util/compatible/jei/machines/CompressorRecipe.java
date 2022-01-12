package sabastians.global.util.compatible.jei.machines;

import java.awt.Color;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import sabastians.global.objects.blocks.machines.compressor.GemstoneCompressorRecipes;
import sabastians.global.util.compatible.jei.JEIAbility;

public class CompressorRecipe implements IRecipeWrapper {
	
	private final List<ItemStack> inputs;
	private final ItemStack output;
	
	public CompressorRecipe(List<ItemStack> inputs, ItemStack output) {
		this.inputs = inputs;
		this.output = output;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInput(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		GemstoneCompressorRecipes recipes = GemstoneCompressorRecipes.getInstance();
		
		float experience = recipes.getCompressorExperience(output);
		
		if(experience > 0)
		{
			String experienceString = JEIAbility.translateToLocalFormatter("gui.jei.category.smelting.experience", experience);
			FontRenderer renderer = minecraft.fontRenderer;
			int stringWidth = renderer.getStringWidth(experienceString);
			renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.GRAY.getRGB());
		}
	}
}