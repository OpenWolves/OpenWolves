package openwolves.api.piles;

import net.minecraft.item.ItemStack;

public class OWPileDrop 
{
	private ItemStack pileblockstack;
	private int outputamount;
	
	public OWPileDrop(ItemStack pileblockstack, int outputamount)
	{
		this.pileblockstack = pileblockstack;
		this.outputamount = outputamount;
	}
	
	public ItemStack getPileBlockStack()
	{
		return this.pileblockstack;
	}
	
	public int getOutputAmount()
	{
		return this.outputamount;
	}
}
