package org.satou.gtlceucore.registry;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.satou.gtlceucore.block.General_Nuke;
import org.satou.gtlceucore.items.Cryolite;
import org.satou.gtlceucore.items.Semiconductor_Polycrystalline_Silicon;
import org.satou.gtlceucore.items.semiconductor_single_crystal_silicon;
import org.slf4j.Logger;


public class RegistryBlockAndItem {
    public static final String MODID = "gtlceucore";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    //public static final RegistryObject<Block> Satou_BLOCK = BLOCKS.register("satou", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(100.f)));
    //public static final RegistryObject<Item> Satou_BLOCK_ITEM = ITEMS.register("satou", () -> new BlockItem(Satou_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Block> General_Nuke = BLOCKS.register("general_nuke", () -> new General_Nuke(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Item> General_Nuke_ITEM = ITEMS.register("general_nuke", () -> new BlockItem(General_Nuke.get(), new Item.Properties()));
    public static final RegistryObject<Item> Cryolite = ITEMS.register("cryolite", () -> new Cryolite(new Item.Properties()));
    public static final RegistryObject<Item> Semiconductor_polycrystalline_silicon = ITEMS.register("semiconductor_polycrystalline_silicon",()-> new Semiconductor_Polycrystalline_Silicon(new Item.Properties()));
    public static final RegistryObject<Item> Semiconductor_single_crystal_silicon = ITEMS.register("semiconductor_single_crystal_silicon",()->new semiconductor_single_crystal_silicon(new Item.Properties()));
    public static final RegistryObject<CreativeModeTab> GTLCEUCore_TAB = CREATIVE_MODE_TABS.register("GTLCEUCore", () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> Cryolite.get().getDefaultInstance()).title(MutableComponent.create(new LiteralContents("GTLCEUCore"))).displayItems((parameters, output) -> {
        //output.accept(Satou_BLOCK_ITEM.get());
        output.accept(General_Nuke_ITEM.get());
        output.accept(Cryolite.get());
        output.accept(Semiconductor_polycrystalline_silicon.get());
        output.accept(Semiconductor_single_crystal_silicon.get());
    }).build());
    public RegistryBlockAndItem() {
    }
}
