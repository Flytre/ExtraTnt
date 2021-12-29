package net.flytre.extratnt.block;

import net.flytre.extratnt.entity.SparklerTntEntity;
import net.flytre.extratnt.publicized.TntBlockPublic;
import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;

public class SparklerTntBlock extends TntBlockPublic {
    public SparklerTntBlock() {
        super(
                (world, x, y, z, igniter) -> {
                    SparklerTntEntity tntEntity = new SparklerTntEntity(Registration.SPARKLER_ENTITY.get(), world);
                    TntEntityPublic.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
