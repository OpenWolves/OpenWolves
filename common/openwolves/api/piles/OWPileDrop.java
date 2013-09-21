package openwolves.api.piles;

import net.minecraft.item.ItemStack;

public class OWPileDrop 
{
	private ItemStack pilestack;
	private ItemStack blocktodroppile;
	
	public OWPileDrop(ItemStack pilestack)
	{
		this(pilestack, new ItemStack(pilestack.itemID, 1, pilestack.getItemDamage()));
	}
	
	public OWPileDrop(ItemStack pilestack, ItemStack blocktodroppile)
	{
		this.pilestack = pilestack;
		this.blocktodroppile = blocktodroppile;
	}
	
	public ItemStack getPileStack()
	{
		return this.pilestack;
	}
	
	public ItemStack getBlockToDropPile()
	{
		return this.blocktodroppile;
	}
}
