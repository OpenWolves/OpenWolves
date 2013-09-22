package openwolves.configuration;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import openwolves.api.OWRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class OWBlockEffectiveness 
{
	public static void init()
	{
		setVanillaHarvestLevels();
		addForcedMaterialToolRequirements();
		forceMaterialsToRequireTool();
	}
	
	private static void setVanillaHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(Block.dirt, "shovel", 0);
		MinecraftForge.setBlockHarvestLevel(Block.grass, "shovel", 0);
	}
	
	private static void addForcedMaterialToolRequirements()
	{
		//OWRegistry.addForcedMaterialToolRequirement(Material.ground);
		//OWRegistry.addForcedMaterialToolRequirement(Material.grass);
	}
	
	private static void forceMaterialsToRequireTool()
	{
		for (int i = 0; i < OWRegistry.forcedtooleffectivelist.size(); i++)
		{
			Material material = OWRegistry.forcedtooleffectivelist.get(i);
			
			try
			{
				ReflectionHelper.findMethod(Material.class, null, new String[] { "setRequiresTool" }, null).invoke(material, null);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
