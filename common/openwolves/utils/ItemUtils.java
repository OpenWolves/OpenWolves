package openwolves.utils;

import java.util.Map;
import java.util.logging.Level;

import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class ItemUtils 
{
	public static int clearItem(Item var1)
	{
		return clearItem(var1.itemID);
	}

	public static int clearItem(Item var1, boolean var2)
	{
		return clearItem(var1.itemID, var2);
	}

	public static int clearItem(int var1)
	{
		return clearItem(var1, true);
	}

	public static int clearItem(int var1, boolean var2)
	{
		if (var1 < 0 || var1 >= Item.itemsList.length)
		{
			FMLLog.log(Level.SEVERE, "BiomesOPlenty has an invalid item ID (%i)", new Object[] {Integer.valueOf(var1)});
		}

		if (var2 && Item.itemsList[var1] == null)
		{
			FMLLog.log(Level.WARNING, "BiomesOPlenty tried clearing an already cleared item (%i)", new Object[] {Integer.valueOf(var1)});
		}

		Item.itemsList[var1] = null;
		Map var3 = (Map)ReflectionHelper.getPrivateValue(GameData.class, null, new String[] {"idMap"});
		var3.remove(Integer.valueOf(var1));
		return var1 - 256;
	}
}
