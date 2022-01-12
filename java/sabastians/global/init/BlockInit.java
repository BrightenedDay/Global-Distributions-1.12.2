package sabastians.global.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import sabastians.global.Main;
import sabastians.global.objects.blocks.BlockBase;
import sabastians.global.objects.blocks.machines.compressor.BlockGemstoneCompressor;

public class BlockInit {
	
	public static List<Block> BLOCKS = new ArrayList<Block>();
													//BlockName, Material, Hardness, Mining Level, HarvestTool, BlastResistance 
	public static final Block BASETILE = new BlockBase("basetile", Material.ROCK, 3, 1, "pickaxe", 7, CreativeTabs.BUILDING_BLOCKS);
	public static final Block COPPER_BLOCK = new BlockBase("copper_block", Material.IRON, 3, 1, "pickaxe", 7, Main.materialstab);
	public static final Block MONSTERMAN_BLOCK = new BlockBase("monsterman_block", Material.IRON, 7, 2, "pickaxe", 26, Main.materialstab);
	public static final Block RAINBOW_BLOCK = new BlockBase("rainbow_block", Material.IRON, 2.3f, 1, "pickaxe", 29, CreativeTabs.DECORATIONS);
	
	// Ores
	
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld", 3, 1, "pickaxe", 7, CreativeTabs.BUILDING_BLOCKS);
	
	//Furnaces
	public static final Block GEMSTONE_COMPRESSOR = new BlockGemstoneCompressor("gemstone_compressor");
}