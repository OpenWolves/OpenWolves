package openwolves.api.piles;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class OWPileRecipe 
{
	private IRecipe recipe;
	private ItemStack pileblockstack;
	
	public OWPileRecipe(IRecipe recipe, ItemStack pileblockstack)
	{
		this.recipe = recipe;
		this.pileblockstack = pileblockstack;
	}
	
	public IRecipe getIRecipe()
	{
		return this.recipe;
	}
	
	public ItemStack getPileBlockStack()
	{
		return this.pileblockstack;
	}
}
