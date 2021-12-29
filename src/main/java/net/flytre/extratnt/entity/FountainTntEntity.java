package net.flytre.extratnt.entity;

import net.flytre.extratnt.publicized.TntEntityPublic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.world.World;


public class FountainTntEntity extends TntEntityPublic {

    private int explodeTime;
    private boolean hasExploded = false;

    public FountainTntEntity(EntityType<? extends TntEntityPublic> entityEntityType, World world) {
        super(entityEntityType,world);
    }



    @Override
    public void tick() {
        if (this.getFuse() == 2 && !hasExploded) {
            this.explodeTime = 60;
            this.hasExploded = true;
        }

        if (explodeTime > 0) {
            this.setFuse(2);
            this.setInvulnerable(true);

            double r = 4.0;
            double theta = (explodeTime / 24.0) * 360;
            double x = r * Math.cos(theta * Math.PI/180);
            double y = 0.6;
            double z = r * Math.sin(theta * Math.PI/180);
            TNTEntity tntEntity = new TNTEntity(world, getPosX(), getPosY(), getPosZ(), this.getCausingEntity());
            tntEntity.setVelocity(x, y, z);
            tntEntity.setFuse(80);
            world.addEntity(tntEntity);
            tntEntity = new TNTEntity(world, getPosX(), getPosY(), getPosZ(), this.getCausingEntity());
            tntEntity.setVelocity(-x, y, -z);
            tntEntity.setFuse(80);
            world.addEntity(tntEntity);

            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }

}
