package net.flytre.extratnt.entity;

import net.flytre.extratnt.publicized.TntEntityPublic;
import net.flytre.extratnt.setup.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;


public class UltimateTntEntity extends TntEntityPublic {


    public UltimateTntEntity(EntityType<? extends TntEntityPublic> entityEntityType, World world) {
        super(entityEntityType,world);
    }

    @Override
    public void explode() {
        GeyserTntEntity center = new GeyserTntEntity(Registration.GEYSER_ENTITY.get(),world);
        TntEntityPublic.update(center,world,getPosX() + 0.5,getPosY(),getPosZ() + 0.5,this.getCausingEntity());
        center.setMotion(this.getMotion());
        world.addEntity(center);
        center = new GeyserTntEntity(Registration.GEYSER_ENTITY.get(),world);
        TntEntityPublic.update(center,world,getPosX() + 0.5,getPosY(),getPosZ() + 0.5,this.getCausingEntity());
        center.setMotion(this.getMotion());
        center.setFuse(20);
        world.addEntity(center);
        PinkTntEntity pink = new PinkTntEntity(Registration.PINK_ENTITY.get(),world);
        TntEntityPublic.update(pink,world,getPosX() + 0.5,getPosY(),getPosZ() + 0.5,this.getCausingEntity());
        pink.setVelocity(0,2.0,0);
        pink.setFuse(20);
        world.addEntity(pink);


        for(double i = 0; i < Math.PI * 2; i += Math.PI / 2) {
            FountainTntEntity side = new FountainTntEntity(Registration.FOUNTAIN_ENTITY.get(),world);
            TntEntityPublic.update(side,world,getPosX() + 0.5,getPosY(),getPosZ() + 0.5,this.getCausingEntity());
            side.setVelocity(Math.sin(i)*1.5,0.5,Math.cos(i)*1.5);
            side.setFuse(20);
            world.addEntity(side);
        }
        super.explode();
    }

}
