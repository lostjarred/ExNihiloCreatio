package exnihiloadscensio;

import exnihiloadscensio.items.*;
import exnihiloadscensio.items.seeds.ItemSeedBase;
import exnihiloadscensio.items.tools.CrookBase;
import exnihiloadscensio.items.tools.HammerBase;
import exnihiloadscensio.registries.OreRegistry;
import exnihiloadscensio.util.Data;
import exnihiloadscensio.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

public class ModItems {

    public static HammerBase hammerWood;
    public static HammerBase hammerStone;
    public static HammerBase hammerIron;
    public static HammerBase hammerDiamond;
    public static HammerBase hammerGold;

    public static CrookBase crookWood;
    public static CrookBase crookBone;

    public static ItemMesh mesh;

    public static ItemResource resources;
    public static ItemCookedSilkworm cookedSilkworm;

    public static ItemPebble pebbles;

    public static ItemDoll dolls;

    public static ArrayList<ItemSeedBase> itemSeeds = new ArrayList<>();

    @SuppressWarnings("deprecation")
    public static void init() {
        hammerWood = new HammerBase("hammer_wood", 64, Item.ToolMaterial.WOOD);
        hammerWood.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        hammerStone = new HammerBase("hammer_stone", 128, Item.ToolMaterial.STONE);
        hammerStone.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        hammerIron = new HammerBase("hammer_iron", 512, Item.ToolMaterial.IRON);
        hammerIron.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        hammerDiamond = new HammerBase("hammer_diamond", 4096, Item.ToolMaterial.DIAMOND);
        hammerDiamond.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        hammerGold = new HammerBase("hammer_gold", 64, Item.ToolMaterial.GOLD);
        hammerGold.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        crookWood = new CrookBase("crook_wood", 64);
        crookWood.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        crookBone = new CrookBase("crook_bone", 256);
        crookBone.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        mesh = new ItemMesh();
        mesh.setCreativeTab(ExNihiloAdscensio.tabExNihilo);

        resources = new ItemResource();
        OreDictionary.registerOre("clay_porcelain", ItemResource.getResourceStack("porcelain_clay"));

        cookedSilkworm = new ItemCookedSilkworm();

        pebbles = new ItemPebble();

        itemSeeds.add(new ItemSeedBase("oak", Blocks.SAPLING.getStateFromMeta(0)));
        itemSeeds.add(new ItemSeedBase("spruce", Blocks.SAPLING.getStateFromMeta(1)));
        itemSeeds.add(new ItemSeedBase("birch", Blocks.SAPLING.getStateFromMeta(2)));
        itemSeeds.add(new ItemSeedBase("jungle", Blocks.SAPLING.getStateFromMeta(3)));
        itemSeeds.add(new ItemSeedBase("acacia", Blocks.SAPLING.getStateFromMeta(4)));
        itemSeeds.add(new ItemSeedBase("dark_oak", Blocks.SAPLING.getStateFromMeta(5)));
        itemSeeds.add(new ItemSeedBase("cactus", Blocks.CACTUS.getDefaultState()).setPlantType(EnumPlantType.Desert));
        itemSeeds.add(new ItemSeedBase("sugarcane", Blocks.REEDS.getDefaultState()).setPlantType(EnumPlantType.Beach));
        itemSeeds.add(new ItemSeedBase("carrot", Blocks.CARROTS.getDefaultState()).setPlantType(EnumPlantType.Crop));
        itemSeeds.add(new ItemSeedBase("potato", Blocks.POTATOES.getDefaultState()).setPlantType(EnumPlantType.Crop));

        dolls = new ItemDoll();
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
        init();

        for (Item item : Data.ITEMS) {
            registry.register(item);
        }
        for (Block block : Data.BLOCKS)
            registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void initModels(ModelRegistryEvent e) {
        for (Item item : Data.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).initModel(e);
            }
        }

        OreRegistry.initModels();
    }

}