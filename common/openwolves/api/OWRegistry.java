package openwolves.api;

import java.awt.List;
import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import openwolves.api.piles.OWPileDropListEntry;

public class OWRegistry 
{
    public static OWPileDropListEntry[] piledroplist = new OWPileDropListEntry[Block.blocksList.length];
    public static ArrayList<Material> forcedtooleffectivelist = new ArrayList();

	public static void addPileDrop(ItemStack pilestack, int blockID)
	{
		addPileDrop(pilestack, blockID, 0);
	}
	
	public static void addPileDrop(ItemStack pilestack, int blockID, int blockmeta)
	{
		if (piledroplist[blockID] == null)
		{
			OWPileDropListEntry piledroplistentry = new OWPileDropListEntry();
			
			piledroplistentry.addPileStackEntry(pilestack, blockmeta);
			piledroplist[blockID] = piledroplistentry;
		}
		else
		{
			System.out.println("[OpenWolves] BlockID " + blockID + " occupied in piledroplist, attempting to add to existing entry...");
			
			OWPileDropListEntry piledroplistentry = piledroplist[blockID];
			
			piledroplistentry.addPileStackEntry(pilestack, blockmeta);
		}
	}
	
	public static void addForcedMaterialToolRequirement(Material material)
	{
		forcedtooleffectivelist.add(material);
	}
}
