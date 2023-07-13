package ca.randomcode.untitled.mixin.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel, HeadedModel {
    @Shadow
    public ModelPart head;
    @Shadow
    public ModelPart hat;
    @Shadow
    public ModelPart body;
    @Shadow
    public ModelPart rightArm;
    @Shadow
    public ModelPart leftArm;
    @Shadow
    public ModelPart rightLeg;
    @Shadow
    public ModelPart leftLeg;
    @Shadow
    public HumanoidModel.ArmPose leftArmPose;
    @Shadow
    public HumanoidModel.ArmPose rightArmPose;
    @Shadow
    public boolean crouching;
    @Shadow
    public float swimAmount;

    public void randomizeLimb(Random random, ModelPart part) {
        part.xRot = random.nextFloat() * 3;
        part.yRot = random.nextFloat() * 3;
        part.zRot = random.nextFloat() * 3;
    }

    @Inject(method = "setupAnim", at = @At("TAIL"))
    public void setupAnim(CallbackInfo callbackInfo) {
        Random random = new Random();
        randomizeLimb(random, this.head);
        randomizeLimb(random, this.hat);
        randomizeLimb(random, this.rightArm);
        randomizeLimb(random, this.leftArm);
        randomizeLimb(random, this.rightLeg);
        randomizeLimb(random, this.leftLeg);
    }
}
