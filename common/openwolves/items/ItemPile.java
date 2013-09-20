package openwolves.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import openwolves.OpenWolves;
import openwolves.api.piles.OWPileUtils;

public class ItemPile extends Item
{
	private Icon pileoutline;
	
	public ItemPile(int id) 
	{
		super(id);
		setCreativeTab(OpenWolves.tabOpenWolves);
	}
	
	@Override
	public void registerIcons(IconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon("openwolves:pile");
		pileoutline = iconregister.registerIcon("openwolves:pileoutline");
	}
	
	public Icon getPileOutline()
	{
		return pileoutline;
	}
	
    @Override
    public String getItemDisplayName(ItemStack itemstack)
    {
    	ItemStack pileBlockItemStack = OWPileUtils.getPileBlockFromPileStack(itemstack);
    	String pileBlockName = StatCollector.translateToLocal(Item.itemsList[pileBlockItemStack.itemID].getUnlocalizedNameInefficiently(pileBlockItemStack) + ".name").trim(); 			
    	
        StringBuilder builder = new StringBuilder();
        builder.append(pileBlockName).append(" ").append(StatCollector.translateToLocal(this.getUnlocalizedName() + ".name"));
        return builder.toString();
    }
}
