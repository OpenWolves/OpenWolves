package openwolves.api;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import openwolves.api.piles.OWPileRecipe;
import openwolves.api.utils.OWCraftingUtils;
import cpw.mods.fml.common.registry.GameRegistry;

public class OWRegistry 
{
    public static ArrayList<OWPileRecipe> pilerecipelist = new ArrayList();
	
	public static void addShapedPileRecipe(ItemStack pileblockstack, Object... params)
	{
		IRecipe recipe = GameRegistry.addShapedRecipe(new ItemStack(OWApiItems.pile.get(), pileblockstack.stackSize));
		pilerecipelist.add(new OWPileRecipe(recipe, pileblockstack));
	}
	
	public static void addShapelessPileRecipe(ItemStack pileblockstack, Object... params)
	{
		IRecipe recipe = OWCraftingUtils.addShapelessRecipe(new ItemStack(OWApiItems.pile.get(), pileblockstack.stackSize), params);
		pilerecipelist.add(new OWPileRecipe(recipe, pileblockstack));
	}
}
