
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
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

@SidedProxy(clientSide = "ninja.ClientProxyNinja", serverSide = "ninja.CommonProxyNinja")
	public static CommonProxyNinja proxy;
	
public static EnumToolMaterial Osmium = EnumHelper.addToolMaterial("Osmium", 4, 20000, 10.0F, 6 , 10);

public static Block OsmiumOre;
public static Block Forgewall;



public static Item Ninjastar;
public static Item Katana;

int OsmiumOreID;
int KatanaID;
int NinjastarID;
@PreInit
public void PreInit(FMLPreInitializationEvent event)
{
	Configuration Config = new Configuration(event.getSuggestedConfigurationFile());
	Config.load();
	OsmiumOreID = Config.get("Block ID's", "Osmium Ore", 500).getInt();
	
	KatanaID = Config.get("Item ID's", "Katana", 5001).getInt();
	NinjastarID = Config.get("Item ID's", "Ninjastar", 5000).getInt();
	Config.save();
}




@Init
	public void load(FMLInitializationEvent event)
	{
	proxy.registerRenderThings();
	Ninjastar = new ItemNinjastar(NinjastarID).setIconIndex(0).setItemName("Ninjastar");
	Forgewall = new BlockForgewall(250, 0).setBlockName("Forgewall");
	Katana = new ItemKatana(KatanaID, Osmium).setItemName("Katana");
	
	
			
			
			gameregistry();
			languageregistry();
	
	GameRegistry.registerWorldGenerator(new WorldGeneratorNinja());
	
	
	}
public void gameregistry()
{
	GameRegistry.registerBlock(OsmiumOre, "Osmium Ore");
	GameRegistry.registerBlock(Forgewall, "forgewall");
	GameRegistry.registerItem(Katana, "Katana");
	
	
}


public void languageregistry()
{
	LanguageRegistry.addName(Forgewall, "Forgewall");
	LanguageRegistry.addName(Ninjastar, "Ninja star");
	LanguageRegistry.addName(Katana, "Katana");
	LanguageRegistry.addName(OsmiumOre, "Osmium Ore");
	
}




}
