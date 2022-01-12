package sabastians.global.world.types;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import sabastians.global.init.BiomeInit;

public class WorldTypeColdstone extends WorldType {
	
	public WorldTypeColdstone() {
		super("Coldstone");
	}
	
	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new BiomeProviderSingle(BiomeInit.COLDSTONE);
	}
}