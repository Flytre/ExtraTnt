package net.flytre.extratnt.tnt;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class FountainTntEntity extends TntEntity {

    private int explodeTime;
    private boolean hasExploded = false;

    public FountainTntEntity(EntityType<FountainTntEntity> entityType, World world) {
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

            double r = 4.0;
            double theta = (explodeTime / 24.0) * 360;
            double x = r * Math.cos(theta * Math.PI / 180);
            double y = 0.6;
            double z = r * Math.sin(theta * Math.PI / 180);
            TntEntity tntEntity = new TntEntity(world, getX(), getY(), getZ(), this.getCausingEntity());
            tntEntity.setVelocity(x, y, z);
            tntEntity.setFuse(80);
            world.spawnEntity(tntEntity);
            tntEntity = new TntEntity(world, getX(), getY(), getZ(), this.getCausingEntity());
            tntEntity.setVelocity(-x, y, -z);
            tntEntity.setFuse(80);
            world.spawnEntity(tntEntity);

            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }

}
