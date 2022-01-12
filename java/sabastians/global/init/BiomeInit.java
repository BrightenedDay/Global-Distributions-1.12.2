package sabastians.global.init;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import sabastians.global.world.biomes.BiomeColdstone;

public class BiomeInit {
	
	public static final Biome COLDSTONE =  new BiomeColdstone();
	
	public static void registerBiomes() {
		
		initBiome(COLDSTONE, "Coldstone", BiomeType.WARM, Type.FOREST);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... type) {
		
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println(name + " Biome Registered");
		BiomeDictionary.addTypes(biome, type);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}