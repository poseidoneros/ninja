package mods.ninja;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = "poseidoneros_ninja", name = "Ninja", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class ninja 
{

@SidedProxy(clientSide = "mods.ninja.ClientProxyNinja", serverSide = "mods.ninja.CommonProxyNinja")
	public static CommonProxyNinja proxy;
	
public static EnumToolMaterial Osmium = EnumHelper.addToolMaterial("Osmium", 4, 20000, 11.0F, 6 , 10);

public static CreativeTabs CreativeTabNinja = new CreativeTabNinja(CreativeTabs.getNextID(),"CreativeTabNinja");


public static Block OsmiumOre;
public static Block Forgewall;
public static Block GlowCrystalOre;

public static Item OsmiumIngot;
public static Item Ninjastar;
public static Item Katana;
public static Item OsmiumPickaxe;

int GlowCrystalOreID;
int GlowCrystalID;
int OsmiumOreID;
int OsmiumIngotID;
int OsmiumPickaxeID;
int KatanaID;
int NinjastarID;
@PreInit
public void PreInit(FMLPreInitializationEvent event)
{
	Configuration Config = new Configuration(event.getSuggestedConfigurationFile());
	Config.load();
	OsmiumOreID = Config.get("Block ID's", "Osmium Ore", 500).getInt();
	GlowCrystalOreID = Config.get("Block ID's", "GlowCrystal Ore", 501).getInt();
	
	
	GlowCrystalID = Config.get("Item ID's", "Glow Crystal", 5003).getInt();
	OsmiumIngotID = Config.get("Item ID's", "Osmium Ingot", 5002).getInt();
	OsmiumPickaxeID = Config.get("item ID's", "Osmium Pickaxe", 5004).getInt();
	KatanaID = Config.get("Item ID's", "Katana", 5001).getInt();
	NinjastarID = Config.get("Item ID's", "Ninjastar", 5000).getInt();
	Config.save();
}




@Init
	public void load(FMLInitializationEvent event)
	{
	proxy.registerRenderThings();
	Forgewall = new BlockForgewall(250, Material.iron).setUnlocalizedName("Forgewall");
	OsmiumOre = new BlockOsmiumOre(OsmiumOreID, Material.iron).setUnlocalizedName("OsmiumOre").setHardness(8.0F);
	GlowCrystalOre = new BlockGlowCrystalOre(GlowCrystalOreID, Material.iron).setUnlocalizedName("GlowCrystalOre").setHardness(4.0F);
	
	OsmiumIngot = new ItemOsmiumIngot(OsmiumIngotID).setUnlocalizedName("OsmiumIngot");
	OsmiumPickaxe = new ItemOsmiumPickaxe(OsmiumPickaxeID, Osmium).setUnlocalizedName("OsmiumPickaxe");
	Ninjastar = new ItemNinjastar(NinjastarID).setUnlocalizedName("Ninjastar");
	Katana = new ItemKatana(KatanaID, Osmium).setUnlocalizedName("Katana");
			
			gameregistry();
			languageregistry();
			Smeltingregistry();
			craftingregistry();
	
			MinecraftForge.setBlockHarvestLevel(OsmiumOre, "pickaxe", 2);
			MinecraftForge.setBlockHarvestLevel(GlowCrystalOre, "pickaxe", 1);
			
			MinecraftForge.setToolClass(OsmiumPickaxe, "Pickaxe", 4);
	
	
	
	}
public void gameregistry()
{
	
	GameRegistry.registerBlock(Forgewall, "forgewall");
	GameRegistry.registerBlock(OsmiumOre, "OsmiumOre");
	GameRegistry.registerBlock(GlowCrystalOre, "GlowCrystalOre");
	GameRegistry.registerItem(Katana, "Katana");
	GameRegistry.registerItem(Ninjastar, "Ninjastar");
	GameRegistry.registerItem(OsmiumPickaxe, "OsmiumPickaxe");
	GameRegistry.registerItem(OsmiumIngot, "OsmiumIngot");
	GameRegistry.registerWorldGenerator(new WorldGeneratorNinja());
	
}


public void languageregistry()
{
	LanguageRegistry.addName(Forgewall, "Forgewall");
	LanguageRegistry.addName(OsmiumOre, "Osmium Ore");
	LanguageRegistry.addName(GlowCrystalOre, "GlowCrystal Ore");
	LanguageRegistry.addName(Ninjastar, "Ninja star");
	LanguageRegistry.addName(OsmiumPickaxe, "Osmium Pickaxe");
	LanguageRegistry.addName(Katana, "Katana");
	LanguageRegistry.addName(OsmiumIngot, "Osmium Ingot");
	
	
}
public void Smeltingregistry()
{
	GameRegistry.addSmelting(OsmiumOreID, new ItemStack(OsmiumIngot, 1), 3F);
	
	
	
}
public void craftingregistry()
{
	GameRegistry.addRecipe(new ItemStack(Katana), new Object[]{
		"  O", " O ", "S  ", 'O', OsmiumIngot, 'S', Item.stick, 
		});
	GameRegistry.addRecipe(new ItemStack(Ninjastar), new Object[]{
		" O ", "O O"," O ", 'O', OsmiumIngot,
	});
	GameRegistry.addRecipe(new ItemStack(OsmiumPickaxe),new Object[]{
		"OOO"," S "," S ", 'O', OsmiumIngot, 'S', Item.stick,
	});
	
	
}

}
