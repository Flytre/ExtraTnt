package net.flytre.extratnt.setup;

import net.flytre.extratnt.publicized.TntEntityRendererPublic;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "extratnt", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Client {


    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Registration.SPARKLER_ENTITY.get(), (i) -> new TntEntityRendererPublic(i, Registration.SPARKLER_TNT.get().getDefaultState()));
        RenderingRegistry.registerEntityRenderingHandler(Registration.PINK_ENTITY.get(), (i) -> new TntEntityRendererPublic(i, Registration.PINK_TNT.get().getDefaultState()));
        RenderingRegistry.registerEntityRenderingHandler(Registration.FOUNTAIN_ENTITY.get(), (i) -> new TntEntityRendererPublic(i, Registration.FOUNTAIN_TNT.get().getDefaultState()));
        RenderingRegistry.registerEntityRenderingHandler(Registration.GEYSER_ENTITY.get(), (i) -> new TntEntityRendererPublic(i, Registration.GEYSER_TNT.get().getDefaultState()));
        RenderingRegistry.registerEntityRenderingHandler(Registration.ULTIMATE_ENTITY.get(), (i) -> new TntEntityRendererPublic(i, Registration.ULTIMATE_TNT.get().getDefaultState()));

    }
}
