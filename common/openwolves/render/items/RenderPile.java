package openwolves.render.items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.client.IItemRenderer;
import openwolves.items.ItemPile;
import openwolves.utils.RenderUtil;

import org.lwjgl.opengl.GL11;

public class RenderPile implements IItemRenderer
{
	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)) || (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.ENTITY));
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return type == IItemRenderer.ItemRenderType.ENTITY;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		Tessellator tessellator = Tessellator.instance;
		
		ItemPile pile = (ItemPile)item.getItem();
		Icon icon = item.getIconIndex();

		GL11.glEnable(3042);

		if (type.equals(IItemRenderer.ItemRenderType.ENTITY)) 
		{
			GL11.glTranslated(-0.5D, -0.1D, 0.0D);
		}

		ItemStack pileBlockStack = pile.getCorrespondingPileBlockItemStack(item);

		if (pileBlockStack != null) 
		{
			Icon pileOutline = pile.getPileOutline();
			Icon pileBlockIcon = Block.blocksList[pileBlockStack.itemID].getIcon(0, pileBlockStack.getItemDamage());

			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);

			GL11.glBlendFunc(0, 1);

			if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) 
			{
				RenderUtil.renderIcon(pileOutline, 16.0D, 0.0D, 0.0F, 0.0F, -1.0F);
			} 
			else 
			{
				ItemRenderer.renderItemIn2D(tessellator, pileOutline.getMaxU(), pileOutline.getMinV(), pileOutline.getMinU(), pileOutline.getMaxV(), pileOutline.getIconWidth(), pileOutline.getIconHeight(), 0.0625F);
			}

			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);

			GL11.glBlendFunc(770, 771);
			GL11.glDepthFunc(514);

			if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) 
			{
				RenderUtil.renderIcon(pileBlockIcon, 16.0D, 0.0D, 0.0F, 0.0F, -1.0F);
			} 
			else 
			{
				ItemRenderer.renderItemIn2D(tessellator, pileBlockIcon.getMaxU(), pileBlockIcon.getMinV(), pileBlockIcon.getMinU(), pileBlockIcon.getMaxV(), pileBlockIcon.getIconWidth(), pileBlockIcon.getIconHeight(), 0.0625F);
			}

			GL11.glDepthFunc(515);
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);

		GL11.glBlendFunc(770, 771);

		if (type.equals(IItemRenderer.ItemRenderType.INVENTORY))
		{
			RenderUtil.renderIcon(icon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
		}
		else 
		{
			ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
		}

		GL11.glDisable(3042);
	}
}