package openwolves.items;

import net.minecraft.client.renderer.texture.IconRegister;
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
	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("openwolves:pileoutline");
	}
	
    @Override
    public String getItemDisplayName(ItemStack itemstack)
    {
    	ItemStack pileBlockItemStack = getCorrespondingPileBlockItemStack(itemstack);
    	String pileBlockName = StatCollector.translateToLocal(Item.itemsList[pileBlockItemStack.itemID].getUnlocalizedNameInefficiently(pileBlockItemStack) + ".name").trim(); 			
    	
        StringBuilder builder = new StringBuilder();
        builder.append(pileBlockName).append(" ").append(StatCollector.translateToLocal(this.getUnlocalizedName() + ".name"));
        return builder.toString();
    }
    
    public static ItemStack getCorrespondingPileBlockItemStack(ItemStack itemstack)
    {
    	addDefaultPileTags(itemstack);
    	
		NBTTagCompound pileTags = itemstack.getTagCompound().getCompoundTag("OW");

    	return new ItemStack(pileTags.getInteger("pileBID"), 1, pileTags.getInteger("pileBMeta"));
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
}
