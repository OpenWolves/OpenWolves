package openwolves.handlers;

import java.util.logging.Level;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler 
{
	private static final String localizationLocation = "/assets/openwolves/lang/";

	public static ResourceLocation[] localeFiles = { new ResourceLocation(localizationLocation + "en_US.xml") };

	public static boolean isXMLLanguageFile(ResourceLocation fileName) 
	{
		return fileName.getResourcePath().endsWith(".xml");
	}

	public static String getLocaleFromFileName(ResourceLocation fileName) 
	{
		FMLCommonHandler.instance().getFMLLogger().log(Level.INFO, "[OpenWolves] Localizations loaded for " + fileName.getResourcePath().substring(fileName.getResourcePath().lastIndexOf('/') + 1, fileName.getResourcePath().lastIndexOf('.')));
		return fileName.getResourcePath().substring(fileName.getResourcePath().lastIndexOf('/') + 1, fileName.getResourcePath().lastIndexOf('.'));
	}

	public String getLocalizedString(String key) 
	{
		return LanguageRegistry.instance().getStringLocalization(key);
	}

	public static void loadLanguages() 
	{	
		for (ResourceLocation localizationFile : localeFiles) 
		{
			LanguageRegistry.instance().loadLocalization(localizationFile.getResourcePath(), getLocaleFromFileName(localizationFile), isXMLLanguageFile(localizationFile));
		}
	}
}
