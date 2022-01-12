package sabastians.global.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import sabastians.global.Main;
import sabastians.global.objects.armor.ArmorBase;
import sabastians.global.objects.armor.MonstermanFlyArmor;
import sabastians.global.objects.items.ItemBase;
import sabastians.global.objects.tools.ModdedSword;
import sabastians.global.objects.tools.ToolAxe;
import sabastians.global.objects.tools.ToolHoe;
import sabastians.global.objects.tools.ToolPickaxe;
import sabastians.global.objects.tools.ToolShovel;
import sabastians.global.objects.tools.ToolSword;
import sabastians.global.util.Reference;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Gears
	public static final Item GEAR_IRON = new ItemBase("gear_iron", Main.materialstab);
	
	//Ingot's
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot", Main.materialstab);
	public static final Item MONSTERMAN_INGOT = new ItemBase("monsterman_ingot", Main.materialstab);
	
	//TypeMaterials
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 180, 5, 1, 7);
	public static final ToolMaterial CELLSTAR_MAT = EnumHelper.addToolMaterial("cellstar_mat", 2, 180, 5000, 1, 7);
	public static final ToolMaterial TOOL_MONSTERMAN = EnumHelper.addToolMaterial("tool_monsterman", 8, 0, 11, 39, 27);
	public static final ToolMaterial LONGTOOL_COPPER = EnumHelper.addToolMaterial("longtool_copper", 3, 380, 7, 3, 11);
	public static final ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("armor_copper", Reference.MODID + ":copper", 12, new int[]{2, 4, 5, 2}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOR_MONSTERMAN = EnumHelper.addArmorMaterial("armor_monsterman", Reference.MODID + ":monsterman", 107000, new int[]{10, 20, 25, 15}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 8.0F);
	
	// Copper Tools
	public static final Item COPPER_SWORD = new ToolSword("copper_sword", TOOL_COPPER);
	public static final Item COPPER_LONGSWORD = new ToolSword("copper_longsword", LONGTOOL_COPPER);
	public static final Item COPPER_PICKAXE = new ToolPickaxe("copper_pickaxe", TOOL_COPPER);
	public static final Item COPPER_AXE = new ToolAxe("copper_axe", TOOL_COPPER, 9f, 0.9f);
	public static final Item COPPER_SHOVEL = new ToolShovel("copper_shovel", TOOL_COPPER);
	public static final Item COPPER_HOE = new ToolHoe("copper_hoe", TOOL_COPPER);
	
	// Copper Armor
	public static final Item COPPER_HELMET = new ArmorBase("copper_helmet", ARMOR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item COPPER_CHESTPLATE = new ArmorBase("copper_chestplate", ARMOR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item COPPER_LEGGINGS = new ArmorBase("copper_leggings", ARMOR_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item COPPER_BOOTS = new ArmorBase("copper_boots", ARMOR_COPPER, 1, EntityEquipmentSlot.FEET);
	
	//public static final Item MONSTERMAN_SWORD = new ToolSword("monsterman_sword", TOOL_MONSTERMAN);
	public static final Item MONSTERMAN_SWORD = new ModdedSword("monsterman_sword", TOOL_MONSTERMAN, 45, 0.2f, MONSTERMAN_INGOT);
	
	public static final Item MONSTERMAN_HELMET = new MonstermanFlyArmor("monsterman_helmet", ARMOR_MONSTERMAN, 1, EntityEquipmentSlot.HEAD, 0.02f);
	public static final Item MONSTERMAN_CHESTPLATE = new MonstermanFlyArmor("monsterman_chestplate", ARMOR_MONSTERMAN, 1, EntityEquipmentSlot.CHEST, 0.02f);
	public static final Item MONSTERMAN_LEGGINGS = new MonstermanFlyArmor("monsterman_leggings", ARMOR_MONSTERMAN, 2, EntityEquipmentSlot.LEGS, 0.02f);
	public static final Item MONSTERMAN_BOOTS = new MonstermanFlyArmor("monsterman_boots", ARMOR_MONSTERMAN, 1, EntityEquipmentSlot.FEET, 0.02f);
}
