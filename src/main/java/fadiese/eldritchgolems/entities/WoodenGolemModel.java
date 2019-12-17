package fadiese.eldritchgolems.entities;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class WoodenGolemModel<T extends WoodenGolemEntity> extends EntityModel<T> {

    private RendererModel main;
    private RendererModel head;
    private RendererModel twig;
    private RendererModel body;
    private RendererModel right_arm;
    private RendererModel left_arm;
    private RendererModel right_leg;
    private RendererModel left_leg;

    public WoodenGolemModel() {
        this(0.0F);
    }

    public WoodenGolemModel(float p_i1161_1_) {
        this(p_i1161_1_, -7.0F);
    }

    public WoodenGolemModel(float p_i46362_1_, float p_i46362_2_) {
        textureWidth = 128;
        textureHeight = 128;

        main = (new RendererModel(this)).setTextureSize(128, 128);
        main.setRotationPoint(0.0F, -92.85F, 0.0F);

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 64.85F, 0.0F);
        main.addChild(head);
        head.cubeList.add(new ModelBox(head, 44, 44, -6.0F, -14.0625F, -5.8542F, 12, 12, 12, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 24, -7.0F, -13.0625F, -6.8542F, 14, 10, 14, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -12.0625F, -7.8542F, 4, 8, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 80, 45, -3.0F, -2.0625F, -2.8542F, 6, 2, 6, 0.0F, false));

        twig = new RendererModel(this);
        twig.setRotationPoint(63.3333F, -60.85F, 1.8333F);
        setRotationAngle(twig, 0.0F, 0.0F, 0.7854F);
        head.addChild(twig);
        twig.cubeList.add(new ModelBox(twig, 0, 24, -9.25F, 71.7875F, -6.6875F, 1, 4, 1, 0.0F, false));
        twig.cubeList.add(new ModelBox(twig, 4, 9, -12.25F, 70.7875F, -5.6875F, 3, 1, 0, 0.0F, false));
        twig.cubeList.add(new ModelBox(twig, 0, 9, -8.25F, 68.7875F, -5.6875F, 2, 3, 0, 0.0F, false));

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 79.2875F, 0.9792F);
        main.addChild(body);
        body.cubeList.add(new ModelBox(body, 0, 0, -12.0F, -14.5F, -6.8333F, 24, 12, 12, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 48, -6.0F, -2.5F, -4.8333F, 12, 7, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 56, 24, -2.0F, 4.5F, -3.8333F, 4, 6, 9, 0.0F, false));

        right_arm = new RendererModel(this);
        right_arm.setRotationPoint(-11.9167F, 68.1208F, 1.1458F);
        main.addChild(right_arm);
        right_arm.cubeList.add(new ModelBox(right_arm, 76, 79, -5.0F, 2.6667F, -2.0F, 4, 17, 4, 0.0F, false));
        right_arm.cubeList.add(new ModelBox(right_arm, 86, 62, -6.0F, -2.3333F, -3.0F, 6, 6, 6, 0.0F, false));
        right_arm.cubeList.add(new ModelBox(right_arm, 56, 68, -6.0F, 19.6667F, -3.0F, 6, 9, 6, 0.0F, false));

        left_arm = new RendererModel(this);
        left_arm.setRotationPoint(12.0833F, 68.1208F, 1.1458F);
        main.addChild(left_arm);
        left_arm.cubeList.add(new ModelBox(left_arm, 72, 0, 1.0F, 2.6667F, -2.0F, 4, 17, 4, 0.0F, false));
        left_arm.cubeList.add(new ModelBox(left_arm, 73, 21, 0.0F, -2.3333F, -3.0F, 6, 6, 6, 0.0F, false));
        left_arm.cubeList.add(new ModelBox(left_arm, 32, 68, 0.0F, 19.6667F, -3.0F, 6, 9, 6, 0.0F, false));

        right_leg = new RendererModel(this);
        right_leg.setRotationPoint(-1.9167F, 88.7875F, 1.1458F);
        main.addChild(right_leg);
        right_leg.cubeList.add(new ModelBox(right_leg, 16, 65, -5.0F, -2.0F, -2.0F, 4, 30, 4, 0.0F, false));
        right_leg.cubeList.add(new ModelBox(right_leg, 32, 83, -6.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        right_leg.cubeList.add(new ModelBox(right_leg, 88, 0, -6.0F, 23.0F, -3.0F, 1, 5, 6, 0.0F, false));
        right_leg.cubeList.add(new ModelBox(right_leg, 56, 83, -1.0F, 23.0F, -3.0F, 1, 5, 6, 0.0F, false));

        left_leg = new RendererModel(this);
        left_leg.setRotationPoint(2.0833F, 88.7875F, 1.1458F);
        main.addChild(left_leg);
        left_leg.cubeList.add(new ModelBox(left_leg, 0, 65, 1.0F, -2.0F, -2.0F, 4, 30, 4, 0.0F, false));
        left_leg.cubeList.add(new ModelBox(left_leg, 80, 33, 0.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
        left_leg.cubeList.add(new ModelBox(left_leg, 42, 24, 5.0F, 23.0F, -3.0F, 1, 5, 6, 0.0F, false));
        left_leg.cubeList.add(new ModelBox(left_leg, 0, 24, 0.0F, 23.0F, -3.0F, 1, 5, 6, 0.0F, false));
    }

    @Override
    public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        main.render(scale);
    }
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        left_leg.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        right_leg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
        left_leg.rotateAngleY = 0.0F;
        right_leg.rotateAngleY = 0.0F;
    }
    public void setRotationAngle(RendererModel rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }
    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int i = entityIn.getAttackTimer();
        if (i > 0) {
            left_arm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float) i - partialTick, 10.0F);
            right_arm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float) i - partialTick, 10.0F);
        } else {
            left_arm.rotateAngleX = (-0.2F + 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
            right_arm.rotateAngleX = (-0.2F - 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
        }
    }
    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}