package openwolves.handlers;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import openwolves.api.OWApiItems;
import openwolves.api.OWRegistry;
import openwolves.items.ItemPile;

public class RecipePile implements IRecipe
{
    private ItemStack output = null;

    @Override
	public boolean matches(InventoryCrafting inventorycrafting, World world)
    {
        for (int r = 0; r < OWRegistry.pilerecipelist.size(); ++r)
        {
            IRecipe irecipe = OWRegistry.pilerecipelist.get(r).getIRecipe();

            if (irecipe.matches(inventorycrafting, world))
            {
            	ItemStack itemstack = new ItemStack(OWApiItems.pile.get(), irecipe.getRecipeOutput().stackSize);
            	
            	ItemPile.addDefaultPileTags(itemstack);
            	NBTTagCompound pileTags = itemstack.getTagCompound().getCompoundTag("OW");
            	
            	int pileBlockId = OWRegistry.pilerecipelist.get(r).getPileBlockId();
            	
            	pileTags.setInteger("pileBID", pileBlockId);
            	
            	output = itemstack;
                return true;
            }
        }
        
        return false;
    }

    @Override
	public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        return this.output.copy();
    }

    @Override
	public int getRecipeSize()
    {
        return 10;
    }

    @Override
	public ItemStack getRecipeOutput()
    {
        return this.output;
    }
}
