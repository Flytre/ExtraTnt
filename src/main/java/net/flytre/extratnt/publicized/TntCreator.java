package net.flytre.extratnt.publicized;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import javax.annotation.Nullable;

@FunctionalInterface
public interface TntCreator {

    TntEntityPublic create(World world, double x, double y, double z, @Nullable LivingEntity igniter);
}
