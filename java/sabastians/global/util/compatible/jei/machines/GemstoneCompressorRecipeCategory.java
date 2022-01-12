package sabastians.global.util.compatible.jei.machines;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sabastians.global.init.BlockInit;
import sabastians.global.util.Reference;
import sabastians.global.util.compatible.jei.RecipeCategories;

public class GemstoneCompressorRecipeCategory extends AbstractGemstoneCompressorCategory<CompressorRecipe> {
	
	private final IDrawable background;
	private final String name;
	private final IDrawable icon;
	
	public GemstoneCompressorRecipeCategory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 7, 150, 70);
		name = "Gemstone Compressor";
		icon = helper.createDrawableIngredient(new ItemStack(Item.getItemFromBlock(BlockInit.GEMSTONE_COMPRESSOR)));
	}
	
	@Override
	public IDrawable getBackground() {
		return this.background;
	}
	
	@Override
	public void drawExtras(Minecraft minecraft) {
		animatedFlame.draw(minecraft, 3, 51);
		animatedArrow.draw(minecraft, 75, 28);
	}
	
	@Override
	public String getTitle() {
		return name;
	}
	
	@Override
	public String getUid() {
		return RecipeCategories.GEMCOMPRESSOR;
	}
	
	public void setRecipe(mezz.jei.api.gui.IRecipeLayout recipeLayout, CompressorRecipe recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 27, 36);
		stacks.init(input2, true, 57, 36);
		stacks.init(output, true, 116, 35);
		stacks.set(ingredients);
	}

	@Override
	public String getModName() {
		return Reference.NAME;
	};
	
	@Override
	public IDrawable getIcon() {
		return icon;
	}
}