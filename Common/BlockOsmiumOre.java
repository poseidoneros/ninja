

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOsmiumOre extends Block
{

	public BlockOsmiumOre(int id, Material mat) 
	{
		super(id, mat);
		this.setCreativeTab(CreativeTabs.tabBlock);
		
	}

	
		public int idDropped(int par1,Random rand, int par2)
		{
			return this.blockID;
		}
	public int quantityDropped(Random rand)
	{
		return 1;
	}

	
	
}
