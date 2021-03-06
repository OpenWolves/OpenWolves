package openwolves;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import openwolves.configuration.OWBlockEffectiveness;
import openwolves.configuration.OWBlocks;
import openwolves.configuration.OWCrafting;
import openwolves.configuration.OWItems;
import openwolves.configuration.configfile.OWConfiguration;
import openwolves.eventhanlders.PileDropEventHandler;
import openwolves.handlers.LocalizationHandler;
import openwolves.proxy.CommonProxyOW;
import openwolves.utils.CreativeTabsOW;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

//Using Semantic Versioning 2.0.0
//MAJOR version when you make incompatible API changes,
//MINOR version when you add functionality in a backwards-compatible manner, and
//PATCH version when you make backwards-compatible bug fixes.

@Mod(modid="OpenWolves", name="Open Wolves", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class OpenWolves
{
	@Instance("OpenWolves")
	public static OpenWolves instance;
	
	@SidedProxy(clientSide="openwolves.proxy.ClientProxyOW", serverSide="openwolves.proxy.CommonProxyOW")
	public static CommonProxyOW proxy;

	public static CreativeTabs tabOpenWolves;
	public static String configPath;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		configPath = event.getModConfigurationDirectory() + "/openwolves/";
		OWConfiguration.init(configPath);
		
		tabOpenWolves = new CreativeTabsOW(CreativeTabs.getNextID(), "tabOpenWolves");
		
		OWBlocks.init();
		OWItems.init();
		OWCrafting.init();
		OWBlockEffectiveness.init();
		
        LocalizationHandler.loadLanguages();
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRendering();
		
		MinecraftForge.EVENT_BUS.register(new PileDropEventHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
