package net.flytre.extra_tnt.tnt;


import net.flytre.extra_tnt.Registry;
import net.flytre.extra_tnt.publicized.ExtraTntBlock;

public class SparklerTntBlock extends ExtraTntBlock {
    public SparklerTntBlock(Settings settings) {
        super(settings,SparklerTntEntity::new);
    }

}
