package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.flytre.extratnt.publicized.ExtraTntBlock;

public class UltimateTntBlock extends ExtraTntBlock {
    public UltimateTntBlock(Settings settings) {
        super(settings,
                (world, x, y, z, igniter) -> {
                    UltimateTntEntity tntEntity = new UltimateTntEntity(ExtraTnt.ULTIMATE, world);
                    TntHelper.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
