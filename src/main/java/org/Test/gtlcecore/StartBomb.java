package org.Test.gtlcecore;

import com.google.common.collect.Sets;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
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
        int bomb_radius = 2705;


            for(int x = 0; x * x <= bomb_radius * bomb_radius;++x){
                for(int z = 0; x * x + z * z <= bomb_radius * bomb_radius;++z){
                    for(int y = -130;y <= 200;++y){
                        for(int m = 0;m <= 3;++m) {
                            //logger.info("RUNRUNRUN");
                            //logger.info("x=" + x + ", y=" + y + ", z=" + z);
                            //logger.info("this=" + this.x + "," + this.y + "," + this.z);
                            double new_x = (int) (this.x + x * dir[m][0]);
                            double new_z = (int) (this.z + z * dir[m][1]);
                            double new_y = y;
                            BlockPos posa = BlockPos.containing(new_x, new_y, new_z);
                            BlockState state = this.world.getBlockState(posa);
                            FluidState fluid = this.world.getFluidState(posa);
                            if(state.isAir()){
                            }
                            if(!state.isAir()){


                                //BlockPos im_posa = posa.immutable();
                                Level ThisWorld = this.world;
                                if(ThisWorld instanceof ServerLevel) {

                                    ServerLevel serverlevel = (ServerLevel) ThisWorld;
                                    //BlockEntity blockentity = state.hasBlockEntity() ? serverlevel.getBlockEntity(posa) : null;
                                    //state.spawnAfterBreak(serverlevel, posa, ItemStack.EMPTY, true);

                                    serverlevel.destroyBlock(posa, false);
                                    //blockentity.setRemoved();
                                    //serverlevel.setBlock(im_posa, this.world. 2);
                                    //state.onRemove(this.world,posa,state,true);
                                    //..state.spawnAfterBreak(serverlevel,posa,ItemStack.EMPTY,true);
                                }
                            }
                        }
                    }
                }
            }
    }
}

