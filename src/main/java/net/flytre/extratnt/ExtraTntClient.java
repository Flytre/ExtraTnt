package net.flytre.extratnt;

import net.fabricmc.api.ClientModInitializer;
import net.flytre.extratnt.publicized.TntRenderer;
import net.flytre.flytre_lib.api.base.registry.EntityRendererRegistry;

public class ExtraTntClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ExtraTnt.SPARKLER, (ctx) -> new TntRenderer(ctx, ExtraTnt.SPARKLER_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(ExtraTnt.PINK, (ctx) -> new TntRenderer(ctx, ExtraTnt.PINK_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(ExtraTnt.FOUNTAIN, (ctx) -> new TntRenderer(ctx, ExtraTnt.FOUNTAIN_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(ExtraTnt.GEYSER, (ctx) -> new TntRenderer(ctx, ExtraTnt.GEYSER_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(ExtraTnt.ULTIMATE, (ctx) -> new TntRenderer(ctx, ExtraTnt.ULTIMATE_BLOCK.getDefaultState()));
    }
}
