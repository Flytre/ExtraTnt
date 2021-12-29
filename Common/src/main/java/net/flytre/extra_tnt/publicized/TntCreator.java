package net.flytre.extra_tnt.publicized;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface TntCreator {

    TntEntity create(World world, double x, double y, double z, @Nullable LivingEntity igniter);
}
