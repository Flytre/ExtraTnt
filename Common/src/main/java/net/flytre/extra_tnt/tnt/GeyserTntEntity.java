package net.flytre.extra_tnt.tnt;

import net.flytre.extra_tnt.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class GeyserTntEntity extends TntEntity {


    private int explodeTime;
    private boolean hasExploded = false;

    public GeyserTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public GeyserTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(Registry.GEYSER_ENTITY.get(), world);
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
