package openwolves.configuration.configfile;

import java.io.File;

public class OWConfiguration 
{
	public static File mainConfigFile;
	public static File idConfigFile;

	public static void init(String configpath)
	{
		mainConfigFile = new File(configpath + "main.cfg");
		idConfigFile = new File(configpath + "ids.cfg");

		//OWConfigurationMain.init(mainConfigFile);
		OWConfigurationIDs.init(idConfigFile);
	}
}
