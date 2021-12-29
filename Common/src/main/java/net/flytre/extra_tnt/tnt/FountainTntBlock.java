package net.flytre.extra_tnt.tnt;


import net.flytre.extra_tnt.publicized.ExtraTntBlock;

public class FountainTntBlock extends ExtraTntBlock {

    public FountainTntBlock(Settings settings) {
        super(settings, FountainTntEntity::new);
    }

}
