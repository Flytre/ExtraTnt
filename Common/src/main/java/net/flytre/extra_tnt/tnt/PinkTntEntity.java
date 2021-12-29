package net.flytre.extra_tnt.tnt;

import net.flytre.extra_tnt.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class PinkTntEntity extends TntEntity {

    private int explodeTime;
    private boolean hasExploded = false;

    public PinkTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public PinkTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(Registry.PINK_ENTITY, world);
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
            this.explodeTime = 24;
            this.hasExploded = true;
        }

        if (explodeTime > 0) {
            this.setFuse(2);
            this.setInvulnerable(true);

            if (explodeTime % 4 == 0)
                for (int i = 0; i < 360; i += 20) {
                    double r = (5 - explodeTime / 4.0);
                    TntEntity tntEntity = new TntEntity(world, getX(), getY(), getZ(), this.getCausingEntity());
                    double x = r * Math.cos(i);
                    double y = r / 5.0;
                    double z = r * Math.sin(i);
                    tntEntity.setVelocity(x, y, z);
                    tntEntity.setFuse(100);
                    world.spawnEntity(tntEntity);
                }
            explodeTime--;
            if (explodeTime == 1 && !hasExploded)
                super.explode();
        }
        super.tick();
    }

}
