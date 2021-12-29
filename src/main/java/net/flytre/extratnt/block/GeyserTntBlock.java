package net.flytre.extratnt.block;

import net.flytre.extratnt.entity.FountainTntEntity;
import net.flytre.extratnt.entity.GeyserTntEntity;
import net.flytre.extratnt.publicized.TntBlockPublic;
import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;

public class GeyserTntBlock extends TntBlockPublic {
    public GeyserTntBlock() {
        super(
                (world, x, y, z, igniter) -> {
                    GeyserTntEntity tntEntity = new GeyserTntEntity(Registration.GEYSER_ENTITY.get(), world);
                    TntEntityPublic.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
