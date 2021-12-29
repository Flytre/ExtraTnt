package net.flytre.extratnt.block;

import net.flytre.extratnt.entity.SparklerTntEntity;
import net.flytre.extratnt.entity.UltimateTntEntity;
import net.flytre.extratnt.publicized.TntBlockPublic;
import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;
import net.minecraft.client.gui.widget.list.ExtendedList;

public class UltimateTntBlock extends TntBlockPublic {
    public UltimateTntBlock() {
        super(
                (world, x, y, z, igniter) -> {
                    UltimateTntEntity tntEntity = new UltimateTntEntity(Registration.ULTIMATE_ENTITY.get(), world);
                    TntEntityPublic.update(tntEntity, world, x, y, z, igniter);
                    return tntEntity;
                });
    }

}
