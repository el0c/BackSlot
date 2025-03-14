package net.backslot;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.backslot.config.BackSlotConfig;
import net.backslot.network.SwitchPacket;
import net.backslot.sound.BackSlotSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BackSlotMain implements ModInitializer {

    public static BackSlotConfig CONFIG = new BackSlotConfig();

    public static final Tag<Item> BACKSLOT_ITEMS = TagFactory.ITEM.create(new Identifier("backslot", "backslot_items"));
    public static final Tag<Item> BELTSLOT_ITEMS = TagFactory.ITEM.create(new Identifier("backslot", "beltslot_items"));

    public static final boolean isMedievalWeaponsLoaded = FabricLoader.getInstance().isModLoaded("medievalweapons");
    public static final boolean isMcdwLoaded = FabricLoader.getInstance().isModLoaded("mcdw");

    @Override
    public void onInitialize() {
        AutoConfig.register(BackSlotConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(BackSlotConfig.class).getConfig();
        BackSlotSounds.init();
        SwitchPacket.init();
    }

}