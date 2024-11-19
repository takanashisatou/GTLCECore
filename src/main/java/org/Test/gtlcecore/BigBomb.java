package org.Test.gtlcecore;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BigBomb extends PrimedTnt {

    public BigBomb(EntityType<? extends PrimedTnt> p_32076_, Level p_32077_) {
        super(p_32076_, p_32077_);
    }

    public BigBomb(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
        super(p_32079_, p_32080_, p_32081_, p_32082_, p_32083_);
    }
    @Override
    protected void explode() {
        float f = 300.F;
        this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 300.0F, Level.ExplosionInteraction.TNT);
    }
}
