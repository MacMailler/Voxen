package net.disya.voxen.game.terrain.block;

import net.disya.voxen.game.terrain.block.render.WaterRender;
import net.disya.voxen.terrain.World;
import net.disya.voxen.terrain.block.Block;

/**
 * Created by nicklaslof on 02/02/15.
 */
public class WaterBlock extends Block {
    protected WaterBlock(byte id, String topTextureRegion) {
        super(id, topTextureRegion, topTextureRegion, topTextureRegion);
        this.blockRender = new WaterRender();
    }

    @Override
    public void onNeighbourBlockChange(int x, int y, int z) {

        checkAndSetWater(x+1,y,z);
        checkAndSetWater(x+1,y,z-1);
        checkAndSetWater(x+1,y,z+1);
        checkAndSetWater(x-1,y,z);
        checkAndSetWater(x-1,y,z-1);
        checkAndSetWater(x-1,y,z+1);
        checkAndSetWater(x,y,z+1);
        checkAndSetWater(x,y,z-1);
    }

    private void checkAndSetWater(int x, int y, int z){
        Block block = World.getBlock(x, y, z);
        if (block.getId() == 0){
            World.setBlock(x,y,z,this,false);
        }
    }

    @Override
    public boolean isPlayerCollidable() {
        return false;
    }

    @Override
    public int getOpacity() {
        return 24;
    }

    @Override
    public boolean isLiquid() {
        return true;
    }
}
