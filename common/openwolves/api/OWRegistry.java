package openwolves.api;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import openwolves.api.utils.OWCraftingUtils;
import cpw.mods.fml.common.registry.GameRegistry;

public class OWRegistry 
{
    public static ArrayList<OWPileRecipe> pilerecipelist = new ArrayList();
	
	public static void addShapedPileRecipe(int pileblockid, int outputamount, Object... params)
	{
		IRecipe recipe = GameRegistry.addShapedRecipe(new ItemStack(OWApiItems.pile.get(), outputamount), params);
		pilerecipelist.add(new OWPileRecipe(recipe, pileblockid));
	}
	
	public static void addShapelessPileRecipe(int pileblockid, int outputamount, Object... params)
	{
		IRecipe recipe = OWCraftingUtils.addShapelessRecipe(new ItemStack(OWApiItems.pile.get(), outputamount), params);
		pilerecipelist.add(new OWPileRecipe(recipe, pileblockid));
	}
}
