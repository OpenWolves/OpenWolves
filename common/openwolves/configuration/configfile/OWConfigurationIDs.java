package openwolves.configuration.configfile;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;

public class OWConfigurationIDs
{
	public static Configuration config;
	
	//Block IDS

	//Item IDs
	public static int pileID;
	
	public static void init(File configFile)
	{
		config = new Configuration(configFile);

		try
		{
			config.load();
			
			pileID = config.getItem("Pile ID", 7000, null).getInt();
			
			FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[OpenWolves] Generated IDs Config!");
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Open Wolves has had a problem loading its configuration");
		}
		finally
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}