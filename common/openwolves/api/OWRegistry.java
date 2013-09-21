package openwolves.api;

import java.util.ArrayList;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import openwolves.api.piles.OWPileDrop;

public class OWRegistry 
{
    public static ArrayList<OWPileDrop> piledroplist = new ArrayList();
    public static ArrayList<Material> forcedtooleffectivelist = new ArrayList();

	public static void addPileDrop(ItemStack pilestack, ItemStack dropperblock)
	{
		piledroplist.add(new OWPileDrop(pilestack, dropperblock));
	}
	
	public static void addForcedMaterialToolRequirement(Material material)
	{
		forcedtooleffectivelist.add(material);
	}
}
