package net.flytre.extratnt.entity;

import net.flytre.extratnt.publicized.TntEntityPublic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.world.World;


public class GeyserTntEntity extends TntEntityPublic {

    private int explodeTime;
    private boolean hasExploded = false;

    public GeyserTntEntity(EntityType<? extends TntEntityPublic> entityEntityType, World world) {
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

            double theta = Math.random() * 2 * Math.PI;
            double radius = Math.random()*0.5 + 0.3;
            double x = Math.cos(theta) * radius;
            double y = 0.5 + radius/0.3;
            double z = Math.sin(theta) * radius;
            TNTEntity tntEntity = new TNTEntity(world,getPosX(),getPosY(),getPosZ(),this.getCausingEntity());
            tntEntity.setVelocity(x,y,z);
            tntEntity.setFuse(140);
            world.addEntity(tntEntity);

            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }

}
