package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.flytre.extratnt.publicized.ExtraTntBlock;

public class PinkTntBlock extends ExtraTntBlock {
    public PinkTntBlock(Settings settings) {
        super(settings,
                (world, x, y, z, igniter) -> {
                    PinkTntEntity tntEntity = new PinkTntEntity(ExtraTnt.PINK, world);
                    TntHelper.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
