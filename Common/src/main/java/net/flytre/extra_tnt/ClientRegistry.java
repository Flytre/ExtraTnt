package net.flytre.extra_tnt;

import net.flytre.extra_tnt.publicized.TntRenderer;
import net.flytre.flytre_lib.loader.LoaderAgnosticClientRegistry;

public class ClientRegistry {

    public static void init() {


        LoaderAgnosticClientRegistry.register(Registry.SPARKLER_ENTITY::get, (ctx) -> new TntRenderer(ctx, Registry.SPARKLER_BLOCK.get().getDefaultState()));
        LoaderAgnosticClientRegistry.register(Registry.PINK_ENTITY::get, (ctx) -> new TntRenderer(ctx, Registry.PINK_BLOCK.get().getDefaultState()));
        LoaderAgnosticClientRegistry.register(Registry.FOUNTAIN_ENTITY::get, (ctx) -> new TntRenderer(ctx, Registry.FOUNTAIN_BLOCK.get().getDefaultState()));
        LoaderAgnosticClientRegistry.register(Registry.GEYSER_ENTITY::get, (ctx) -> new TntRenderer(ctx, Registry.GEYSER_BLOCK.get().getDefaultState()));
        LoaderAgnosticClientRegistry.register(Registry.ULTIMATE_ENTITY::get, (ctx) -> new TntRenderer(ctx, Registry.ULTIMATE_BLOCK.get().getDefaultState()));
    }
}
