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
		addPileRecipes();
		addSmeltingRecipes();
	}

	private static void addCraftingRecipes()
	{		
		GameRegistry.addRecipe(new RecipePile());
	}
	
	private static void addPileRecipes()
	{
		OWRegistry.addShapelessPileRecipe(new ItemStack(Block.dirt, 4), new Object[] {new ItemStack(Block.dirt, 1)});
		OWRegistry.addShapelessPileRecipe(new ItemStack(Block.sand, 4), new Object[] {new ItemStack(Block.sand, 1)});
		OWRegistry.addShapelessPileRecipe(new ItemStack(Block.slowSand, 4), new Object[] {new ItemStack(Block.slowSand, 1)});
	}

	private static void addSmeltingRecipes()
	{
	}

	private static void addOreRegistration()
	{
	}
}
