package net.flytre.extratnt;

import net.flytre.extratnt.setup.Client;
import net.flytre.extratnt.setup.ModSetup;
import net.flytre.extratnt.setup.Registration;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.crash.CrashReport;
import net.minecraft.item.ToolItem;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("extratnt")
public class ExtraTnt
{
    public static final Logger LOGGER = LogManager.getLogger();



    public ExtraTnt() {
        MinecraftForge.EVENT_BUS.register(this);

        Registration.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
    }
}
