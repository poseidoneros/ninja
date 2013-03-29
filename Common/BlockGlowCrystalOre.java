

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockGlowCrystalOre extends Block
{

	public BlockGlowCrystalOre(int id, Material mat) {
		super(id, mat);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightValue(1.0F);
	}
public int idDropped(int par1, Random rand ,int par2)
{
	return this.blockID;
}
public int quantityDropped(Random rand)
{
	return 1;
}
	
	
}
