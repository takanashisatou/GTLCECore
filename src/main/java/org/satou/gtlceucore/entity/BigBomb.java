package org.satou.gtlceucore.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.satou.gtlceucore.utils.StartBomb;

public class BigBomb extends PrimedTnt {
    public LivingEntity player;
    public Level world;
    public BigBomb(EntityType<? extends PrimedTnt> p_32076_, Level p_32077_) {
        super(p_32076_, p_32077_);
    }

    public BigBomb(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
        super(p_32079_, p_32080_, p_32081_, p_32082_, p_32083_);
        this.player = p_32083_;
        this.world = p_32079_;
    }

    @Override
    protected void explode() {
        float f = 300.F;
        SatouExplode(this.world, this.getX(), this.getY(), this.getZ());
        //this.level().explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 30000.0F, Level.ExplosionInteraction.TNT);
    }

    private void SatouExplode(Level world, double x, double y, double z) {
        this.level().playSound((Player) null,x,y,z, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS,1.0F,1.0F);
        this.level().gameEvent(player, GameEvent.EXPLODE, new Vec3(x, y, z));
        for (Player player1 : this.level().players()) {
            player1.kill();
        }
        StartBomb startBomb = new StartBomb(world, x, y, z);
        //Thread thread = new Thread(startBomb);
        //thread.start();
        startBomb.run();
    }
}
