package sabastians.global.util.compatible.jei;

import java.util.IllegalFormatException;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;
import sabastians.global.objects.blocks.machines.compressor.ContainerGemstoneCompressor;
import sabastians.global.objects.blocks.machines.compressor.GuiGemstoneCompressor;
import sabastians.global.util.compatible.jei.machines.CompressorRecipeMaker;
import sabastians.global.util.compatible.jei.machines.GemstoneCompressorRecipeCategory;

@SuppressWarnings("deprecation")
@JEIPlugin
public class JEIAbility implements IModPlugin {
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		final IJeiHelpers helper = registry.getJeiHelpers();
		final IGuiHelper gui = helper.getGuiHelper();
		
		registry.addRecipeCategories(new GemstoneCompressorRecipeCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry) {
		final IIngredientRegistry iIngredientRegistry = registry.getIngredientRegistry();
		final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(CompressorRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.GEMCOMPRESSOR);
		registry.addRecipeClickArea(GuiGemstoneCompressor.class, 110, 0, 50, 50, RecipeCategories.GEMCOMPRESSOR);
		recipeTransfer.addRecipeTransferHandler(ContainerGemstoneCompressor.class, RecipeCategories.GEMCOMPRESSOR, 0, 1, 3, 36);
	}
	
	public static String translateToLocal(String key) {
		if(I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	
	public static String translateToLocalFormatter(String key, Object... format) {
		String s = translateToLocal(key);
		try {
			return String.format(s, format);
		} catch (IllegalFormatException e) {
			return "Format Error: " + s;
		}
	}
}