package org.satou.gtlcecore.utils;

import net.minecraft.world.level.Level;
import org.satou.gtlcecore.GTLCECore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Logger logger = GTLCECore.LOGGER;
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

