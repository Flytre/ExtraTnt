package net.flytre.extra_tnt.tnt;


import net.flytre.extra_tnt.Registry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class UltimateTntEntity extends TntEntity {

    public UltimateTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }

    public UltimateTntEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(Registry.ULTIMATE_ENTITY.get(), world);
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
        super.tick();
    }

    @Override
    public void explode() {
        GeyserTntEntity center = new GeyserTntEntity(world, getX() + 0.5, getY(), getZ() + 0.5, this.getCausingEntity());
        center.setVelocity(this.getVelocity());
        world.spawnEntity(center);

        center = new GeyserTntEntity(world, getX() + 0.5, getY(), getZ() + 0.5, this.getCausingEntity());
        center.setVelocity(this.getVelocity());
        center.setFuse(20);
        world.spawnEntity(center);

        PinkTntEntity pink = new PinkTntEntity(world, getX() + 0.5, getY(), getZ() + 0.5, this.getCausingEntity());
        pink.setVelocity(0, 2.0, 0);
        pink.setFuse(20);
        world.spawnEntity(pink);


        for (double i = 0; i < Math.PI * 2; i += Math.PI / 2) {
            FountainTntEntity side = new FountainTntEntity(world, getX() + 0.5, getY(), getZ() + 0.5, this.getCausingEntity());
            side.setVelocity(Math.sin(i) * 1.5, 0.5, Math.cos(i) * 1.5);
            side.setFuse(20);
            world.spawnEntity(side);
        }
        super.explode();
    }

}
