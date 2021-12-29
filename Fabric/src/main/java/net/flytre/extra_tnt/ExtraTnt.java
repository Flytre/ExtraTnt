package net.flytre.extra_tnt;

import net.fabricmc.api.ModInitializer;
import net.flytre.flytre_lib.loader.LoaderProperties;

public class ExtraTnt implements ModInitializer {
    @Override
    public void onInitialize() {
        Registry.init();
    }
}
