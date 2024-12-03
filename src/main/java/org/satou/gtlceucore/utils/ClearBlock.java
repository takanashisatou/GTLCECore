package org.satou.gtlceucore.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class ClearBlock implements Runnable {
    private int radius;
    private double x;
    private double y;
    private double z;
    private Level world;
    public ClearBlock(int radius, double x, double y, double z, Level world) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }
    @Override
    public void run(){
        int[][] dir = {{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int x = 0; x * x <= radius * radius;++x) {
            int z = (int)Math.sqrt((double) radius * radius - (double) x * (double) x);
            for (int nz = 0; nz < z; nz++) {
                for (int y = -130; y <= 200; ++y) {
                    for (int m = 0; m <= 3; ++m) {

                        //logger.info("RUNRUNRUN");
                        //logger.info("x=" + x + ", y=" + y + ", z=" + z);
                        //logger.info("this=" + this.x + "," + this.y + "," + this.z);
                        double new_x = (int) (this.x + x * dir[m][0]);
                        double new_z = (int) (this.z + nz * dir[m][1]);
                        double new_y = y;
                        BlockPos posa = BlockPos.containing(new_x, new_y, new_z);
                        BlockState state = this.world.getBlockState(posa);
                        FluidState fluid = this.world.getFluidState(posa);
                        if (state.isAir()) {
                        }
                        if (!state.isAir()) {


                            //BlockPos im_posa = posa.immutable();
                            Level ThisWorld = this.world;
                            if (ThisWorld instanceof ServerLevel) {

                                ServerLevel serverlevel = (ServerLevel) ThisWorld;
                                //BlockEntity blockentity = state.hasBlockEntity() ? serverlevel.getBlockEntity(posa) : null;
                                //state.spawnAfterBreak(serverlevel, posa, ItemStack.EMPTY, true);

                                //serverlevel.destroyBlock(posa, false);
                                BlockState blockstate = serverlevel.getBlockState(posa);

                                serverlevel.setBlock(posa, Blocks.AIR.defaultBlockState(), 2);
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
