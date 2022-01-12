package sabastians.global.objects.armor;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sabastians.global.Main;
import sabastians.global.init.ItemInit;
import sabastians.global.util.interfaces.IHasModel;

public class MonstermanFlyArmor extends ItemArmor implements IHasModel {

	private float flySpeed;
	private boolean fullArmor = false;
	
	public MonstermanFlyArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, float flySpeed) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		this.flySpeed = flySpeed;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(fullArmor) tooltip.add("\u00A76" + "Full Set Bonus (Slow Fly, No Fall Damage)");
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

		if (player.inventory.armorItemInSlot(3).getItem() == ItemInit.MONSTERMAN_HELMET && player.inventory.armorItemInSlot(2).getItem() == ItemInit.MONSTERMAN_CHESTPLATE && player.inventory.armorItemInSlot(1).getItem() == ItemInit.MONSTERMAN_LEGGINGS && player.inventory.armorItemInSlot(0).getItem() == ItemInit.MONSTERMAN_BOOTS) {
			fullArmor = true;
			if(!player.isCreative()) {
			player.fallDistance = 0.0F;
			player.capabilities.allowFlying = true;
			player.capabilities.setFlySpeed(flySpeed);
			}
		}
		else {
			fullArmor = false;
			player.capabilities.setFlySpeed(0.1f);
			if(!player.isCreative()) {
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			}
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		fullArmor = false;
	}
}