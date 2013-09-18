package openwolves.configuration;

import openwolves.api.OWApiItems;
import openwolves.configuration.configfile.OWConfigurationIDs;
import openwolves.items.ItemPile;

import com.google.common.base.Optional;

public class OWItems 
{
	public static void init()
	{
		initializeItems();
	}

	private static void initializeItems()
	{
		// Item declaration
		OWApiItems.pile = Optional.of(new ItemPile(OWConfigurationIDs.pileID).setUnlocalizedName("ow.pile"));
	}
}
