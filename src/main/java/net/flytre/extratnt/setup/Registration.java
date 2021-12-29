package net.flytre.extratnt.setup;

import net.flytre.extratnt.block.*;
import net.flytre.extratnt.entity.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

    TNTEntity

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "extratnt");
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "extratnt");
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, "extratnt");


    public static final RegistryObject<Block> SPARKLER_TNT = BLOCKS.register("sparkler", SparklerTntBlock::new);
    private static final RegistryObject<Item> SPARKLER_ITEM = ITEMS.register("sparkler", () -> new BlockItem(SPARKLER_TNT.get(),new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> PINK_TNT = BLOCKS.register("pink", PinkTntBlock::new);
    private static final RegistryObject<Item> PINK_ITEM = ITEMS.register("pink", () -> new BlockItem(PINK_TNT.get(),new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> FOUNTAIN_TNT = BLOCKS.register("fountain", FountainTntBlock::new);
    private static final RegistryObject<Item> FOUNTAIN_ITEM = ITEMS.register("fountain", () -> new BlockItem(FOUNTAIN_TNT.get(),new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> GEYSER_TNT = BLOCKS.register("geyser", GeyserTntBlock::new);
    private static final RegistryObject<Item> GEYSER_ITEM = ITEMS.register("geyser", () -> new BlockItem(GEYSER_TNT.get(),new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> ULTIMATE_TNT = BLOCKS.register("ultimate", UltimateTntBlock::new);
    private static final RegistryObject<Item> ULTIMATE_ITEM = ITEMS.register("ultimate", () -> new BlockItem(ULTIMATE_TNT.get(),new Item.Properties().group(ItemGroup.REDSTONE)));


    public static final RegistryObject<EntityType<SparklerTntEntity>> SPARKLER_ENTITY = ENTITIES.register("sparkler",
            () -> EntityType.Builder.create(SparklerTntEntity::new, EntityClassification.MISC)
                    .immuneToFire().size(0.98F, 0.98F).trackingRange(10).func_233608_b_(10)
                    .build("sparkler")
    );
    public static final RegistryObject<EntityType<PinkTntEntity>> PINK_ENTITY = ENTITIES.register("pink",
            () -> EntityType.Builder.create(PinkTntEntity::new, EntityClassification.MISC)
                    .immuneToFire().size(0.98F, 0.98F).trackingRange(10).func_233608_b_(10)
                    .build("pink")
    );
    public static final RegistryObject<EntityType<FountainTntEntity>> FOUNTAIN_ENTITY = ENTITIES.register("fountain",
            () -> EntityType.Builder.create(FountainTntEntity::new, EntityClassification.MISC)
                    .immuneToFire().size(0.98F, 0.98F).trackingRange(10).func_233608_b_(10)
                    .build("fountain")
    );
    public static final RegistryObject<EntityType<GeyserTntEntity>> GEYSER_ENTITY = ENTITIES.register("geyser",
            () -> EntityType.Builder.create(GeyserTntEntity::new, EntityClassification.MISC)
                    .immuneToFire().size(0.98F, 0.98F).trackingRange(10).func_233608_b_(10)
                    .build("geyser")
    );

    public static final RegistryObject<EntityType<UltimateTntEntity>> ULTIMATE_ENTITY = ENTITIES.register("ultimate",
            () -> EntityType.Builder.create(UltimateTntEntity::new, EntityClassification.MISC)
                    .immuneToFire().size(0.98F, 0.98F).trackingRange(10).func_233608_b_(10)
                    .build("ultimate")
    );

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

}
