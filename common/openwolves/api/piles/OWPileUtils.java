package openwolves.api.piles;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import openwolves.api.OWApiItems;

public class OWPileUtils 
{
    public static ItemStack getPileBlockFromPileStack(ItemStack itemstack)
    {
    	addDefaultPileTags(itemstack);
    	
		NBTTagCompound pileTags = itemstack.getTagCompound().getCompoundTag("OW");

    	return new ItemStack(pileTags.getInteger("pileBID"), 1, pileTags.getInteger("pileBMeta"));
    }
    
	public static ItemStack createPileStack(int pileblockid, int stacksize)
	{
		return createPileStack(pileblockid, stacksize, 0);
	}
    
	public static ItemStack createPileStack(int pileblockid, int stacksize, int pileblockmeta)
	{
		ItemStack pileStack = new ItemStack(OWApiItems.pile.get(), stacksize);
		
		addDefaultPileTags(pileStack);
		
    	NBTTagCompound pileTags = pileStack.getTagCompound().getCompoundTag("OW");
    	
    	pileTags.setInteger("pileBID", pileblockid);
    	pileTags.setInteger("pileBMeta", pileblockmeta);
    	
    	return pileStack;
	}
    
    public static void addDefaultPileTags(ItemStack itemstack)
    {
		if (!itemstack.hasTagCompound())
		{
			NBTTagCompound compound = new NBTTagCompound();
			itemstack.setTagCompound(compound);
		}
		
		if (!itemstack.getTagCompound().hasKey("OW"))
		{
			NBTTagCompound compound = itemstack.getTagCompound();
			compound.setCompoundTag("OW", new NBTTagCompound());
		}
		
		NBTTagCompound pileTags = itemstack.getTagCompound().getCompoundTag("OW");
		
		if (!pileTags.hasKey("pileBID"))
		{
			pileTags.setInteger("pileBID", 1);
		}
		
		if (!pileTags.hasKey("pileBMeta"))
		{
			pileTags.setInteger("pileBMeta", 0);
		}
    }
    
    public static void addShapelessPileRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        CraftingManager.getInstance().getRecipeList().add(new ShapelessPileRecipes(par1ItemStack, arraylist));
    }
}
