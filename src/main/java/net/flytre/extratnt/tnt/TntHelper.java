package net.flytre.extratnt.tnt;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;

public class TntHelper {

    public static void update(TntEntity entity, World world, double x, double y, double z, LivingEntity igniter) {
        entity.updatePosition(x, y, z);
        double d = world.random.nextDouble() * 6.2831854820251465D;
        entity.setVelocity(-Math.sin(d) * 0.02D, 0.20000000298023224D, -Math.cos(d) * 0.02D);
        entity.setFuse(80);
        entity.prevX = x;
        entity.prevY = y;
        entity.prevZ = z;
        entity.causingEntity = igniter;
    }

}
