package sabastians.global.world.biomes;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeColdstone extends Biome {

	//protected static final WorldGenAbstractTree TREE = new WorldGenCUSTOMTREE();
	
	public BiomeColdstone() {
		super(new BiomeProperties("Coldstone").setBaseHeight(4.5f).setHeightVariation(0.2f).setTemperature(0.2f).setWaterColor(0));
		
		topBlock = Blocks.STONE.getDefaultState();
		fillerBlock = Blocks.STONE.getDefaultState();
		
		//this.decorator.treesPerChunk = 2;
		
		//this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		//this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 13, 2, 6));
	}
	
	@Override
	public int getSkyColorByTemp(float currentTemperature) {
		return 0;
	}
	
}