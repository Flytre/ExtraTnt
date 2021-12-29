package net.flytre.extratnt.block;

import net.flytre.extratnt.entity.FountainTntEntity;
import net.flytre.extratnt.entity.PinkTntEntity;
import net.flytre.extratnt.publicized.TntBlockPublic;
import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;

public class FountainTntBlock extends TntBlockPublic {
    public FountainTntBlock() {
        super(
                (world, x, y, z, igniter) -> {
                    FountainTntEntity tntEntity = new FountainTntEntity(Registration.FOUNTAIN_ENTITY.get(), world);
                    TntEntityPublic.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
