package openwolves.configuration;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import openwolves.api.OWRegistry;
import openwolves.handlers.RecipePile;
import cpw.mods.fml.common.registry.GameRegistry;

public class OWCrafting
{
	public static void init()
	{
		addOreRegistration();
		addCraftingRecipes();
		addSmeltingRecipes();
	}

	private static void addCraftingRecipes()
	{		
		GameRegistry.addRecipe(new RecipePile());
		
		OWRegistry.addShapedPileRecipe(Block.dirt.blockID, 4, new Object[] {"XRX", 'R', new ItemStack(Block.dirt)});
	}

	private static void addSmeltingRecipes()
	{
	}

	private static void addOreRegistration()
	{
	}
}
