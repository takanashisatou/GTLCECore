package org.Test.gtlcecore;

import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.property.Properties;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class StartBomb implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(StartBomb.class);
    private Level world;
    private double x;
    private double y;
    private double z;
    public StartBomb(Level level,double x,double y,double z) {
        this.world = level;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public void run() {
        Boolean flag = true;
        Logger logger = Gtlcecore.LOGGER;
        //logger.info("RunHereRunHereSatou");
        int[][] dir = {{1,1},{1,-1},{-1,1},{-1,-1}};
        int bomb_radius = 256;
            for(int radius = 0; radius <= bomb_radius;++radius){
                ClearBlock clearBlock = new ClearBlock(radius,x,y,z,world);
                Thread thread = new Thread(clearBlock);
                //clearBlock.run();
                thread.start();
            }
    }
}

