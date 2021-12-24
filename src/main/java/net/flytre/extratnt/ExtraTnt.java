package net.flytre.extratnt;

import net.fabricmc.api.ModInitializer;
import net.flytre.extratnt.tnt.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExtraTnt implements ModInitializer {

    public static final SparklerTntBlock SPARKLER_BLOCK = new SparklerTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final PinkTntBlock PINK_BLOCK = new PinkTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final FountainTntBlock FOUNTAIN_BLOCK = new FountainTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final GeyserTntBlock GEYSER_BLOCK = new GeyserTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
    public static final UltimateTntBlock ULTIMATE_BLOCK = new UltimateTntBlock(AbstractBlock.Settings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

    public static final EntityType<SparklerTntEntity> SPARKLER = register(new Identifier("extratnt", "sparkler"),SparklerTntEntity::new);
    public static final EntityType<PinkTntEntity> PINK = register(new Identifier("extratnt", "pink"),PinkTntEntity::new);
    public static final EntityType<FountainTntEntity> FOUNTAIN = register(new Identifier("extratnt", "fountain"),FountainTntEntity::new);
    public static final EntityType<GeyserTntEntity> GEYSER = register(new Identifier("extratnt", "geyser"),GeyserTntEntity::new);
    public static final EntityType<UltimateTntEntity> ULTIMATE = register(new Identifier("extratnt", "ultimate"),UltimateTntEntity::new);


    private static <T extends Entity> EntityType<T> register(Identifier id, EntityType.EntityFactory<T> creator) {
        return Registry.register(
                Registry.ENTITY_TYPE,
                id,
                EntityType.Builder.create(creator, SpawnGroup.MISC)
                        .setDimensions(0.98f, 0.98f)
                        .makeFireImmune()
                        .maxTrackingRange(10)
                        .trackingTickInterval(10)
                        .build(id.toString())
        );
    }

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("extratnt", "sparkler"), SPARKLER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("extratnt", "sparkler"), new BlockItem(SPARKLER_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));

        Registry.register(Registry.BLOCK, new Identifier("extratnt", "pink"), PINK_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("extratnt", "pink"), new BlockItem(PINK_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));

        Registry.register(Registry.BLOCK, new Identifier("extratnt", "fountain"), FOUNTAIN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("extratnt", "fountain"), new BlockItem(FOUNTAIN_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));

        Registry.register(Registry.BLOCK, new Identifier("extratnt", "geyser"), GEYSER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("extratnt", "geyser"), new BlockItem(GEYSER_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));


        Registry.register(Registry.BLOCK, new Identifier("extratnt", "ultimate"), ULTIMATE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("extratnt", "ultimate"), new BlockItem(ULTIMATE_BLOCK, new Item.Settings().group(ItemGroup.REDSTONE)));

    }
}
