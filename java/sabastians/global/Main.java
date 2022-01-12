package sabastians.global;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sabastians.global.proxy.CommonProxy;
import sabastians.global.tabs.MachineTab;
import sabastians.global.tabs.MaterialsTab;
import sabastians.global.util.Reference;
import sabastians.global.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class Main {
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs materialstab = new MaterialsTab("materialstab");
	public static final CreativeTabs machinetab = new MachineTab("machinetab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegistryHandler.initRegistries();
	}
	@EventHandler
	public void postIniy(FMLPostInitializationEvent event) {
		RegistryHandler.postInitRegistries();
	}
}