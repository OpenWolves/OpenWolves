package openwolves.utils;

import java.util.Map;
import java.util.logging.Level;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
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
	
	public static void dropItemInWorld(ItemStack itemstack, World world, int x, int y, int z)
	{
        if (itemstack != null)
        {
            float f = world.rand.nextFloat() * 0.8F + 0.1F;
            float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
            EntityItem entityitem;

            for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
            {
                int k1 = world.rand.nextInt(21) + 10;

                if (k1 > itemstack.stackSize)
                {
                    k1 = itemstack.stackSize;
                }

                itemstack.stackSize -= k1;
                entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));
                float f3 = 0.05F;
                entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

                if (itemstack.hasTagCompound())
                {
                    entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                }
            }
        }
	}
}
