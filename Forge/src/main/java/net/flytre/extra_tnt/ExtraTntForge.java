package net.flytre.extra_tnt;


import net.flytre.flytre_lib.loader.LoaderCore;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExtraTntForge {

    public ExtraTntForge() {
        LoaderCore.registerForgeMod(Constants.MOD_ID, Registry::init);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientRegistry.init();
        }
    }
}