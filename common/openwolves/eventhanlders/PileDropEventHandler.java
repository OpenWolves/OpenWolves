package openwolves.eventhanlders;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent;
import openwolves.api.OWRegistry;
import openwolves.api.piles.OWPileDropListEntry;
import openwolves.api.piles.OWPileUtils;
import openwolves.utils.ItemUtils;

public class PileDropEventHandler 
{
	@ForgeSubscribe
	public void onBlockDrop(BlockEvent.HarvestDropsEvent event)
	{
		World world = event.world;
		OWPileDropListEntry piledroplistentry = OWRegistry.piledroplist[event.block.blockID];
		
		if (!world.isRemote)
		{
			if (piledroplistentry != null)
			{
				ItemStack pileStack = piledroplistentry.getPileStackEntryForMeta(event.blockMetadata);

				if (pileStack != null)
				{
					//event.drops.removeAll(event.drops);
					//event.drops.add(pileStack);
					ItemUtils.dropItemInWorld(pileStack, world, event.x, event.y, event.z);
				}
			}
		}

				/*if (equippedItem != null && ForgeHooks.canToolHarvestBlock(event.block, event.blockMetadata, equippedItem))*/
	}
}
