package sabastians.global.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import sabastians.global.objects.blocks.machines.compressor.ContainerGemstoneCompressor;
import sabastians.global.objects.blocks.machines.compressor.GuiGemstoneCompressor;
import sabastians.global.objects.blocks.machines.compressor.TileEntityGemstoneCompressor;
import sabastians.global.util.Reference;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_GEMSTONE_COMPRESSOR) return new ContainerGemstoneCompressor(player.inventory, (TileEntityGemstoneCompressor)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Reference.GUI_GEMSTONE_COMPRESSOR) return new GuiGemstoneCompressor(player.inventory, (TileEntityGemstoneCompressor)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}