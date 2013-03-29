package mods.ninja;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabNinja extends CreativeTabs
{

	public CreativeTabNinja(int par1, String par2Str) {
		super(par1, par2Str);
		
	}

	@SideOnly(Side.CLIENT)
	public int tabIconIteIndex()
	{
		return ninja.Ninjastar.itemID;
	}
	public String getTranslatedTabLabel()
	{
		return "Ninja";
	}
	
}
