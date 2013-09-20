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
		
		OWRegistry.addShapelessPileRecipe(new ItemStack(Block.cloth.blockID, 4, 10), new Object[] {new ItemStack(Block.dirt, 1)});
	}

	private static void addSmeltingRecipes()
	{
	}

	private static void addOreRegistration()
	{
	}
}
