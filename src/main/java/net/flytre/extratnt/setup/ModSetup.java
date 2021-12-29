package net.flytre.extratnt.setup;


import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = "extratnt", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static void init(final FMLCommonSetupEvent event) {
        Networking.registerMessages();
    }
}
