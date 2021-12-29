package net.flytre.extratnt.entity;

import net.flytre.extratnt.publicized.TntEntityPublic;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.world.World;


public class PinkTntEntity extends TntEntityPublic {

    private int explodeTime;
    private boolean hasExploded = false;

    public PinkTntEntity(EntityType<? extends TntEntityPublic> entityEntityType, World world) {
        super(entityEntityType,world);
    }



    @Override
    public void tick() {
        if (this.getFuse() == 2 && !hasExploded) {
            this.explodeTime = 24;
            this.hasExploded = true;
        }

        if (explodeTime > 0) {
            this.setFuse(2);
            this.setInvulnerable(true);

            if (explodeTime % 4 == 0)
                for (int i = 0; i < 360; i += 20) {
                    double r = (5 - explodeTime/4.0);
                    TNTEntity tntEntity = new TNTEntity(world, getPosX(), getPosY(), getPosZ(), this.getCausingEntity());
                    double x = r * Math.cos(i);
                    double y = r / 5.0;
                    double z = r * Math.sin(i);
                    tntEntity.setVelocity(x, y, z);
                    tntEntity.setFuse(100);
                    world.addEntity(tntEntity);
                }
            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }


}
