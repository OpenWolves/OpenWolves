package openwolves.api;

import net.minecraft.item.crafting.IRecipe;

public class OWPileRecipe 
{
	private IRecipe recipe;
	private int pileblockid;
	
	public OWPileRecipe(IRecipe recipe, int pileblockid)
	{
		this.recipe = recipe;
		this.pileblockid = pileblockid;
	}
	
	public IRecipe getIRecipe()
	{
		return this.recipe;
	}
	
	public int getPileBlockId()
	{
		return this.pileblockid;
	}
}
