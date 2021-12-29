package net.flytre.extra_tnt;


import net.flytre.flytre_lib.loader.LoaderProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExtraTntForge {

    public ExtraTntForge() {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientRegistry.init();
        }
    }

    @SubscribeEvent
    public static void onLoadComplete(FMLLoadCompleteEvent event) {
    }

    @SubscribeEvent
    public void preInit(FMLCommonSetupEvent event) {

    }
}