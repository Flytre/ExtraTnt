package net.flytre.extratnt.tnt;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;


public class SparklerTntEntity extends TntEntity {

    private int explodeTime;
    private boolean hasExploded = false;

    public SparklerTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType,world);
    }


    @Override
    public void tick() {
        if(this.getFuse() == 2 && !hasExploded) {
            this.explodeTime = 24;
            this.hasExploded = true;
        }

        if(explodeTime > 0) {
            this.setFuse(2);
            this.setInvulnerable(true);
            double theta = (24 - explodeTime) * 15;
            double radius = (theta/360.0)*0.4 + 0.8;
            double x = Math.cos(theta) * radius;
            double y = 0.5 + radius/0.3;
            double z = Math.sin(theta) * radius;
            TntEntity tntEntity = new TntEntity(world,getX(),getY(),getZ(),this.getCausingEntity());
            tntEntity.setVelocity(x,y,z);
            tntEntity.setFuse(180);
            world.spawnEntity(tntEntity);
            explodeTime--;

        }
        super.tick();
    }

}
