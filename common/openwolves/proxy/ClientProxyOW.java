package openwolves.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import openwolves.api.OWApiItems;
import openwolves.render.items.RenderPile;


public class ClientProxyOW extends CommonProxyOW
{
	@Override
	public void registerRendering()
	{
		MinecraftForgeClient.registerItemRenderer(OWApiItems.pile.get().itemID, new RenderPile());
	}
}
