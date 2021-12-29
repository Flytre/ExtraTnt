package net.flytre.extratnt.entity;

import net.flytre.extratnt.publicized.TntEntityPublic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.world.World;


public class SparklerTntEntity extends TntEntityPublic {

    private int explodeTime;
    private boolean hasExploded = false;

    public SparklerTntEntity(EntityType<? extends TntEntityPublic> entityEntityType, World world) {
        super(entityEntityType,world);
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
            TNTEntity tntEntity = new TNTEntity(world,getPosX(),getPosY(),getPosZ(),this.getCausingEntity());
            tntEntity.setVelocity(x,y,z);
            tntEntity.setFuse(180);
            world.addEntity(tntEntity);
            explodeTime--;

        }
        super.tick();
    }

}
