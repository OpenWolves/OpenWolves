package openwolves.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import openwolves.OpenWolves;

public class ItemPile extends Item
{
	public ItemPile(int id) 
	{
		super(id);
		setCreativeTab(OpenWolves.tabOpenWolves);
	}
	
    @Override
    public String getItemDisplayName(ItemStack itemstack)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Block.blocksList[getCorrespondingPileBlockID(itemstack)].getLocalizedName()).append(" ").append(StatCollector.translateToLocal(this.getUnlocalizedName() + ".name"));
        return builder.toString();
    }
    
    public static int getCorrespondingPileBlockID(ItemStack itemstack)
    {
    	addDefaultPileTags(itemstack);
    	
		NBTTagCompound pileTags = itemstack.getTagCompound().getCompoundTag("OW");

    	return pileTags.getInteger("pileBID");
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
    }
}
