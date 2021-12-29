package net.flytre.extra_tnt.tnt;


import net.flytre.extra_tnt.publicized.ExtraTntBlock;

public class GeyserTntBlock extends ExtraTntBlock {
    public GeyserTntBlock(Settings settings) {
        super(settings, GeyserTntEntity::new);
    }

}
