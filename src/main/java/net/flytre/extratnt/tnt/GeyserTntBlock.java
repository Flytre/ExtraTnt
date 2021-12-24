package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.flytre.extratnt.publicized.ExtraTntBlock;

public class GeyserTntBlock extends ExtraTntBlock {
    public GeyserTntBlock(Settings settings) {
        super(settings,
                (world, x, y, z, igniter) -> {
                    GeyserTntEntity tntEntity = new GeyserTntEntity(ExtraTnt.GEYSER, world);
                    TntHelper.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
