package org.Test.gtlcecore;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.extensions.IForgeBlock;

import javax.annotation.Nullable;

public class General_Nuke extends TntBlock implements IForgeBlock {
    public General_Nuke(Properties properties) {
        super(properties.mapColor(MapColor.STONE).strength(3.0f));
    }

    private static void explode(Level p_57437_, BlockPos p_57438_, @Nullable LivingEntity p_57439_) {
        if (!p_57437_.isClientSide) {
            BigBomb bigBomb = new BigBomb(p_57437_, (double)p_57438_.getX() + 0.5D, (double)p_57438_.getY(), (double)p_57438_.getZ() + 0.5D, p_57439_);
            p_57437_.addFreshEntity(bigBomb);
            p_57437_.playSound((Player)null, bigBomb.getX(), bigBomb.getY(), bigBomb.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            p_57437_.gameEvent(p_57439_, GameEvent.PRIME_FUSE, p_57438_);
        }
    }
}
