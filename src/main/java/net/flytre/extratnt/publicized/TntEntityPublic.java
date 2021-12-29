package net.flytre.extratnt.publicized;

import net.minecraft.entity.*;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class TntEntityPublic extends Entity {

    private static final DataParameter<Integer> FUSE = EntityDataManager.createKey(TNTEntity.class, DataSerializers.VARINT);
    @Nullable
    private LivingEntity causingEntity;
    private int fuse = 80;

    public TntEntityPublic(EntityType<? extends TntEntityPublic> type, World worldIn) {
        super(type, worldIn);
        this.preventEntitySpawning = true;
    }


    public static void update(TntEntityPublic entity, World world, double x, double y, double z, LivingEntity igniter) {
        entity.setPosition(x, y, z);
        double d = world.rand.nextDouble() * 6.2831854820251465D;
        entity.setVelocity(-Math.sin(d) * 0.02D, 0.20000000298023224D, -Math.cos(d) * 0.02D);
        entity.setFuse(80);
        entity.prevPosX = x;
        entity.prevPosY = y;
        entity.prevPosZ = z;
        entity.causingEntity = igniter;
    }


    protected void registerData() {
        this.dataManager.register(FUSE, 80);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean canBeCollidedWith() {
        return !this.removed;
    }

    public void tick() {
        if (!this.hasNoGravity()) {
            this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
        }

        this.move(MoverType.SELF, this.getMotion());
        this.setMotion(this.getMotion().scale(0.98D));
        if (this.onGround) {
            this.setMotion(this.getMotion().mul(0.7D, -0.5D, 0.7D));
        }

        --this.fuse;
        if (this.fuse <= 0) {
            this.remove();
            if (!this.world.isRemote) {
                this.explode();
            }
        } else {
            this.func_233566_aG_();
            if (this.world.isRemote) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void explode() {
        float f = 4.0F;
        this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 4.0F, Explosion.Mode.BREAK);
    }

    protected void writeAdditional(CompoundNBT compound) {
        compound.putShort("Fuse", (short) this.getFuse());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditional(CompoundNBT compound) {
        this.setFuse(compound.getShort("Fuse"));
    }

    @Nullable
    public LivingEntity getCausingEntity() {
        return this.causingEntity;
    }

    protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.15F;
    }

    public void notifyDataManagerChange(DataParameter<?> key) {
        if (FUSE.equals(key)) {
            this.fuse = this.getFuseDataManager();
        }

    }

    /**
     * Gets the fuse from the data manager
     */
    public int getFuseDataManager() {
        return this.dataManager.get(FUSE);
    }

    public int getFuse() {
        return this.fuse;
    }

    public void setFuse(int fuseIn) {
        this.dataManager.set(FUSE, fuseIn);
        this.fuse = fuseIn;
    }

    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }


}
