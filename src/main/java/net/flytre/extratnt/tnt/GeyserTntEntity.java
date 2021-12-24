package net.flytre.extratnt.tnt;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;


public class GeyserTntEntity extends TntEntity {


    private int explodeTime;
    private boolean hasExploded = false;

    public GeyserTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
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
            double radius = Math.random() * 0.5 + 0.3;
            double x = Math.cos(theta) * radius;
            double y = 0.5 + radius / 0.3;
            double z = Math.sin(theta) * radius;
            TntEntity tntEntity = new TntEntity(world, getX(), getY(), getZ(), this.getCausingEntity());
            tntEntity.setVelocity(x, y, z);
            tntEntity.setFuse(140);
            world.spawnEntity(tntEntity);

            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }

}
