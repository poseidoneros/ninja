

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNinjastar extends Item
{

	public ItemNinjastar(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			--par1ItemStack.stackSize;
		}
		par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!par2World.isRemote)
		{
			par2World.spawnEntityInWorld(new EntityNinjastar(par2World, par3EntityPlayer));
		}
		return par1ItemStack;
	}
	

}
