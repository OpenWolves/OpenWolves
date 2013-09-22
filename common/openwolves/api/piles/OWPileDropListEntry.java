package openwolves.api.piles;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class OWPileDropListEntry 
{
    private ItemStack[] metadata = new ItemStack[16];
	
    public void addPileStackEntry(ItemStack pilestack)
    {
    	addPileStackEntry(pilestack, 0);
    }
	
	public void addPileStackEntry(ItemStack pilestack, int blockmeta)
	{
    	if (metadata[blockmeta] == null)
    	{
    		metadata[blockmeta] = pilestack;
    	}
    	else
    	{
            System.out.println("[OpenWolves] Metadata " + blockmeta + " is already occupied for this entry!");
    	}
	}
	
	public ItemStack getPileStackEntryForMeta(int blockmeta)
	{
		return metadata[blockmeta];
	}
}
