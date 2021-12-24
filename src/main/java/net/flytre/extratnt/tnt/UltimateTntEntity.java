package net.flytre.extratnt.tnt;

import net.flytre.extratnt.ExtraTnt;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;


public class UltimateTntEntity extends TntEntity {

    public UltimateTntEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void explode() {
        GeyserTntEntity center = new GeyserTntEntity(ExtraTnt.GEYSER,world);
        TntHelper.update(center,world,getX() + 0.5,getY(),getZ() + 0.5,this.getCausingEntity());
        center.setVelocity(this.getVelocity());
        world.spawnEntity(center);
        center = new GeyserTntEntity(ExtraTnt.GEYSER,world);
        TntHelper.update(center,world,getX() + 0.5,getY(),getZ() + 0.5,this.getCausingEntity());
        center.setVelocity(this.getVelocity());
        center.setFuse(20);
        world.spawnEntity(center);
        PinkTntEntity pink = new PinkTntEntity(ExtraTnt.PINK,world);
        TntHelper.update(pink,world,getX() + 0.5,getY(),getZ() + 0.5,this.getCausingEntity());
        pink.setVelocity(0,2.0,0);
        pink.setFuse(20);
        world.spawnEntity(pink);


        for(double i = 0; i < Math.PI * 2; i += Math.PI / 2) {
            FountainTntEntity side = new FountainTntEntity(ExtraTnt.FOUNTAIN,world);
            TntHelper.update(side,world,getX() + 0.5,getY(),getZ() + 0.5,this.getCausingEntity());
            side.setVelocity(Math.sin(i)*1.5,0.5,Math.cos(i)*1.5);
            side.setFuse(20);
            world.spawnEntity(side);
        }
        super.explode();
    }

}
