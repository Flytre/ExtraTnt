package net.flytre.extra_tnt;

import net.fabricmc.api.ClientModInitializer;
import net.flytre.extra_tnt.publicized.TntRenderer;
import net.flytre.flytre_lib.api.base.registry.EntityRendererRegistry;
import net.flytre.flytre_lib.loader.LoaderProperties;

public class ExtraTntClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientRegistry.init();
    }
}
