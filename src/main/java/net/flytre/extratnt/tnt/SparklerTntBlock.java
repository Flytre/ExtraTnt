package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.flytre.extratnt.publicized.ExtraTntBlock;

public class SparklerTntBlock extends ExtraTntBlock {
    public SparklerTntBlock(Settings settings) {
        super(settings,
                (world, x, y, z, igniter) -> {
                    SparklerTntEntity tntEntity = new SparklerTntEntity(ExtraTnt.SPARKLER, world);
                    TntHelper.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
