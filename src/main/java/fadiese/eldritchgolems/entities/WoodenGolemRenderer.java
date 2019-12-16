package fadiese.eldritchgolems.entities;

import com.mojang.blaze3d.platform.GlStateManager;
import fadiese.eldritchgolems.EldritchGolems;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WoodenGolemRenderer extends MobRenderer<WoodenGolemEntity, WoodenGolemModel<WoodenGolemEntity>> {
    private static final ResourceLocation WOODEN_GOLEM_TEXTURES = new ResourceLocation(EldritchGolems.MODID,"textures/entity/wooden_golem.png");

    public WoodenGolemRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new WoodenGolemModel<>(), 0.7F);
    }

    protected ResourceLocation getEntityTexture(WoodenGolemEntity entity) {
        return WOODEN_GOLEM_TEXTURES;
    }

    protected void applyRotations(WoodenGolemEntity entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
        if (!((double) entityLiving.limbSwingAmount < 0.01D)) {
            float f = 13.0F;
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
            GlStateManager.rotatef(6.5F * f2, 0.0F, 0.0F, 1.0F);
        }
    }
}
