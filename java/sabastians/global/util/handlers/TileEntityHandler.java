package sabastians.global.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import sabastians.global.objects.blocks.machines.compressor.TileEntityGemstoneCompressor;

public class TileEntityHandler {
	
	@SuppressWarnings("deprecation")
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityGemstoneCompressor.class, "gemstone_compressor");
	}
}