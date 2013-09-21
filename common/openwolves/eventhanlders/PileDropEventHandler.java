package openwolves.eventhanlders;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent;

public class PileDropEventHandler 
{
	@ForgeSubscribe
	public void onBlockDrop(BlockEvent.HarvestDropsEvent event)
	{
		/*ItemStack dropperBlock = new ItemStack(event.block, 1, event.blockMetadata);
		
		System.out.println("T");
		
		for (int i = 0; i < OWRegistry.piledroplist.size(); i++)
		{
			OWPileDrop piledrop = OWRegistry.piledroplist.get(i);
			
			if (piledrop.getBlockToDropPile().itemID == dropperBlock.itemID && piledrop.getBlockToDropPile().getItemDamage() == dropperBlock.getItemDamage())
			{
				ItemStack equippedItem = event.harvester.getCurrentEquippedItem();

				if (equippedItem != null && ForgeHooks.canToolHarvestBlock(event.block, event.blockMetadata, equippedItem))
				{
				}
				else
				{
					System.out.println("Bla");
					event.drops.removeAll(event.drops);
					event.drops.add(piledrop.getPileStack());
				}
			}
		}*/
	}
}
