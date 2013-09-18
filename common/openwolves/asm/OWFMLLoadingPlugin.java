package openwolves.asm;

import java.io.File;
import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

@TransformerExclusions({ "openwolves.asm" })
@MCVersion(value = "1.6.2")
public class OWFMLLoadingPlugin implements IFMLLoadingPlugin 
{
	public static File location;

	@Override
	public String[] getASMTransformerClass() 
	{
		return new String[] {OWClassTransformerOverride.class.getName()};
	}


	@Override
	public void injectData(Map<String, Object> data) 
	{
		location = (File)data.get("coremodLocation");
	}


	@SuppressWarnings("deprecation")
	@Deprecated
	@Override
	public String[] getLibraryRequestClass() 
	{
		return null;
	}


	@Override
	public String getModContainerClass() 
	{
		return null;
	}


	@Override
	public String getSetupClass() 
	{
		return null;
	}
}