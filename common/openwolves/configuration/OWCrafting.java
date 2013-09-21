package openwolves.configuration;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import openwolves.api.OWRegistry;
import openwolves.api.piles.OWPileUtils;
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
	}
	
	private static void addPileRecipes()
	{    	
		GameRegistry.addShapelessRecipe(OWPileUtils.createPileStack(Block.dirt.blockID, 4), new Object[] {new ItemStack(Block.dirt, 1)});
		GameRegistry.addShapelessRecipe(OWPileUtils.createPileStack(Block.sand.blockID, 4), new Object[] {new ItemStack(Block.sand, 1)});
		GameRegistry.addShapelessRecipe(OWPileUtils.createPileStack(Block.slowSand.blockID, 4), new Object[] {new ItemStack(Block.slowSand, 1)});
		
		OWPileUtils.addShapelessPileRecipe(new ItemStack(Block.dirt), new Object[] {OWPileUtils.createPileStack(Block.dirt.blockID, 1), OWPileUtils.createPileStack(Block.dirt.blockID, 1), OWPileUtils.createPileStack(Block.dirt.blockID, 1), OWPileUtils.createPileStack(Block.dirt.blockID, 1)});
		OWPileUtils.addShapelessPileRecipe(new ItemStack(Block.sand), new Object[] {OWPileUtils.createPileStack(Block.sand.blockID, 1), OWPileUtils.createPileStack(Block.sand.blockID, 1), OWPileUtils.createPileStack(Block.sand.blockID, 1), OWPileUtils.createPileStack(Block.sand.blockID, 1)});
		OWPileUtils.addShapelessPileRecipe(new ItemStack(Block.slowSand), new Object[] {OWPileUtils.createPileStack(Block.slowSand.blockID, 1), OWPileUtils.createPileStack(Block.slowSand.blockID, 1), OWPileUtils.createPileStack(Block.slowSand.blockID, 1), OWPileUtils.createPileStack(Block.slowSand.blockID, 1)});
	
		OWRegistry.addPileDrop(OWPileUtils.createPileStack(Block.dirt.blockID, 4), new ItemStack(Block.dirt, 1));
		OWRegistry.addPileDrop(OWPileUtils.createPileStack(Block.dirt.blockID, 4), new ItemStack(Block.grass, 1));
	}

	private static void addSmeltingRecipes()
	{
	}

	private static void addOreRegistration()
	{
	}
}
