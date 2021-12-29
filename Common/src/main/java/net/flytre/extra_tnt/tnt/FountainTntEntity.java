package net.flytre.extra_tnt.tnt;

import net.flytre.extra_tnt.Registry;
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

    public FountainTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(Registry.FOUNTAIN_ENTITY, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * Math.PI * 2;
        this.setVelocity(-Math.sin(d) * 0.02D, 0.2D, -Math.cos(d) * 0.02D);
        this.setFuse(80);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
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
