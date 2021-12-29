package net.flytre.extra_tnt.tnt;


import net.flytre.extra_tnt.publicized.ExtraTntBlock;
import net.minecraft.entity.TntEntity;

public class UltimateTntBlock extends ExtraTntBlock {

    public UltimateTntBlock(Settings settings) {
        super(settings, UltimateTntEntity::new);
    }

}
