package net.flytre.extra_tnt;

import net.flytre.extra_tnt.tnt.*;
import net.flytre.flytre_lib.loader.LoaderProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class Registry {

    public static final SparklerTntBlock SPARKLER_BLOCK = registerBlock(new SparklerTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS)), "sparkler");
    public static final PinkTntBlock PINK_BLOCK = registerBlock(new PinkTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS)), "pink");
    public static final FountainTntBlock FOUNTAIN_BLOCK = registerBlock(new FountainTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS)), "fountain");
    public static final GeyserTntBlock GEYSER_BLOCK = registerBlock(new GeyserTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS)), "geyser");
    public static final UltimateTntBlock ULTIMATE_BLOCK = registerBlock(new UltimateTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS)), "ultimate");

    public static final EntityType<SparklerTntEntity> SPARKLER_ENTITY = register(SparklerTntEntity::new, "sparkler");
    public static final EntityType<PinkTntEntity> PINK_ENTITY = register(PinkTntEntity::new, "pink");
    public static final EntityType<FountainTntEntity> FOUNTAIN_ENTITY = register(FountainTntEntity::new, "fountain");
    public static final EntityType<GeyserTntEntity> GEYSER_ENTITY = register(GeyserTntEntity::new, "geyser");
    public static final EntityType<UltimateTntEntity> ULTIMATE_ENTITY = register(UltimateTntEntity::new, "ultimate");


    public static <T extends Block> T registerBlock(T block, String id) {
        var tmp = LoaderProperties.register(block, "extra_tnt", id);
        LoaderProperties.register(new BlockItem(block, new Item.Settings().group(ItemGroup.REDSTONE)), "extra_tnt", id);
        return tmp;
    }

    public static <E extends Entity> EntityType<E> register(EntityType.EntityFactory<E> factory, String id) {
        return LoaderProperties.register(
                EntityType.Builder.create(factory, SpawnGroup.MISC)
                        .setDimensions(0.98f, 0.98f)
                        .makeFireImmune()
                        .maxTrackingRange(10)
                        .trackingTickInterval(10)
                        .build(id), "extra_tnt", id);
    }

    public static void init() {
    }


}
