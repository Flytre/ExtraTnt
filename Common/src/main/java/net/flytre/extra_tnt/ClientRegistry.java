package net.flytre.extra_tnt;

import net.flytre.extra_tnt.publicized.TntRenderer;
import net.flytre.flytre_lib.loader.LoaderProperties;

public class ClientRegistry {

    public static void init() {
        LoaderProperties.register(Registry.SPARKLER_ENTITY, (ctx) -> new TntRenderer(ctx, Registry.SPARKLER_BLOCK.getDefaultState()));
        LoaderProperties.register(Registry.PINK_ENTITY, (ctx) -> new TntRenderer(ctx, Registry.PINK_BLOCK.getDefaultState()));
        LoaderProperties.register(Registry.FOUNTAIN_ENTITY, (ctx) -> new TntRenderer(ctx, Registry.FOUNTAIN_BLOCK.getDefaultState()));
        LoaderProperties.register(Registry.GEYSER_ENTITY, (ctx) -> new TntRenderer(ctx, Registry.GEYSER_BLOCK.getDefaultState()));
        LoaderProperties.register(Registry.ULTIMATE_ENTITY, (ctx) -> new TntRenderer(ctx, Registry.ULTIMATE_BLOCK.getDefaultState()));
    }
}
