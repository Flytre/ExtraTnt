package net.flytre.extratnt.block;

import net.flytre.extratnt.entity.PinkTntEntity;
import net.flytre.extratnt.entity.SparklerTntEntity;
import net.flytre.extratnt.publicized.TntBlockPublic;
import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;

public class PinkTntBlock extends TntBlockPublic {
    public PinkTntBlock() {
        super(
                (world, x, y, z, igniter) -> {
                    PinkTntEntity tntEntity = new PinkTntEntity(Registration.PINK_ENTITY.get(), world);
                    TntEntityPublic.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
