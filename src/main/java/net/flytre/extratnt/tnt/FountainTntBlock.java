package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.flytre.extratnt.publicized.ExtraTntBlock;

public class FountainTntBlock extends ExtraTntBlock {

    public FountainTntBlock(Settings settings) {
        super(settings,
                (world, x, y, z, igniter) -> {
                    FountainTntEntity tntEntity = new FountainTntEntity(ExtraTnt.FOUNTAIN, world);
                    TntHelper.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
