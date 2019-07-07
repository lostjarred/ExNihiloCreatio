package exnihilocreatio.recipes.defaults;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.modules.forestry.ForestryHelper;
import exnihilocreatio.registries.registries.*;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;

public class Forestry implements IRecipeDefaults {
    @Getter
    private final String MODID = "forestry";

    @Override
    public void registerCompost(CompostRegistry registry) {
        BlockInfo dirtState = new BlockInfo(Blocks.DIRT);

        // Compost Drones
        registry.register(new ItemInfo("forestry:bee_drone_ge"), 0.0625f, dirtState, new Color("C45631"));
        registry.register(new ItemInfo("forestry:bee_princess_ge"), 0.25f, dirtState, new Color("C45631"));
        registry.register(new ItemInfo("forestry:bee_larvae_ge"), 0.0625f, dirtState, new Color("C45631"));
        registry.register(new ItemInfo("forestry:cocoon_ge"), 0.0625f, dirtState, new Color("C45631"));
        registry.register(new ItemInfo("forestry:caterpillar_ge"), 0.0625f, dirtState, new Color("C45631"));
        // Compost Peat
        registry.register(new ItemInfo("forestry:peat"), 0.5f, dirtState, new Color("AF9F96"));
        // Compost Compost (yo dawg)
        registry.register(new ItemInfo("forestry:fertilizer_bio"), 0.5f, dirtState, new Color("135303"));
        // Compost Mouldy Wheat, Decaying Wheat, Mulch
        registry.register(new ItemInfo("forestry:mouldy_wheat"), 0.0625f, dirtState, new Color("D3D152"));
        registry.register(new ItemInfo("forestry:decaying_wheat"), 0.125f, dirtState, new Color("D3D152"));
        registry.register(new ItemInfo("forestry:mulch"), 0.25f, dirtState, new Color("D3D152"));
        // Compost Wood Pulp
        registry.register(new ItemInfo("forestry:wood_pulp"), 0.125f, dirtState, new Color("FFF1B5"));
        // Compost Pollens
        registry.register(new ItemInfo("forestry:pollen:0"), 0.125f, dirtState, new Color("FFFA66"));
        registry.register(new ItemInfo("forestry:pollen:1"), 0.125f, new BlockInfo(Blocks.SNOW, -1), new Color("709BD3"));
        registry.register(new ItemInfo("forestry:pollen_fertile"), 0.25f, dirtState, new Color("FFFA66"));

        registry.register(new ItemInfo("forestry:propolis:0"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("forestry:propolis:1"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));
        registry.register(new ItemInfo("forestry:propolis:3"), 0.125f, new BlockInfo(Blocks.SLIME_BLOCK), new Color("7B934B"));

    }

    @Override
    public void registerCrook(CrookRegistry registry) {
        // All Leaves for Forest Bees
        registerCrookBees(registry, "treeLeaves", "magicbees.speciesForest", .02f, .01f, .001f);
        // Jungle Leaves for Tropical
        registerCrookBees(registry, Blocks.LEAVES, 3, "magicbees.speciesTropical", .02f, .01f, .001f);
        registerCrookBees(registry, Blocks.LEAVES, 11, "magicbees.speciesTropical", .02f, .01f, .001f);
        registerCrookBees(registry, Blocks.LEAVES, 15, "magicbees.speciesTropical", .02f, .01f, .001f);
        // Sand for Modest Bees
        registerCrookBees(registry, "sand", "magicbees.speciesModest", .05f, .02f, .01f);
        // Snow for Wintry Bees
        registerCrookBees(registry, Blocks.SNOW, -1, "magicbees.speciesWintry", .05f, .02f, .01f);
        // Crushed End Stone for Ender Bees
        registerCrookBees(registry, ModBlocks.endstoneCrushed, -1, "magicbees.speciesEnded", .05f, .02f, .01f);
        // Dirt for Meadows
        registerCrookBees(registry, "dirt", "magicbees.speciesMeadows", .05f, .02f, .01f);

    }

    private void registerCrookBees(CrookRegistry registry, String oredict, String species, float drone, float ignoble, float pristine) {
        registry.register(oredict, ForestryHelper.getDroneInfo(species).getItemStack(), drone, drone*2);
        registry.register(oredict, ForestryHelper.getIgnobleInfo(species).getItemStack(), ignoble, ignoble/2);
        registry.register(oredict, ForestryHelper.getPristineInfo(species).getItemStack(), pristine, pristine*2);
    }

    private void registerCrookBees(CrookRegistry registry, Block target, int meta, String species, float drone, float ignoble, float pristine) {
        registry.register(target, meta, ForestryHelper.getDroneInfo(species).getItemStack(), drone, drone*2);
        registry.register(target, meta, ForestryHelper.getIgnobleInfo(species).getItemStack(), ignoble, ignoble/2);
        registry.register(target, meta, ForestryHelper.getPristineInfo(species).getItemStack(), pristine, pristine*2);
    }

    @Override
    public void registerSieve(SieveRegistry registry) {
        // Sand for Apatite
        registry.register("sand", new ItemInfo("forestry:apatite"), 0.01f, BlockSieve.MeshType.STRING.getID());
        registry.register("sand", new ItemInfo("forestry:apatite"), 0.02f, BlockSieve.MeshType.FLINT.getID());
        registry.register("sand", new ItemInfo("forestry:apatite"), 0.03f, BlockSieve.MeshType.IRON.getID());
        registry.register("sand", new ItemInfo("forestry:apatite"), 0.05f, BlockSieve.MeshType.DIAMOND.getID());

        /*
         BEEEEEEEEEES
         */

        // Leaves for Forest Bees
        registry.register("treeLeaves", ForestryHelper.getDroneInfo("forestry.speciesForest"), 0.05f, BlockSieve.MeshType.FLINT.getID());
        registry.register("treeLeaves", ForestryHelper.getIgnobleInfo("forestry.speciesForest"), 0.05f, BlockSieve.MeshType.IRON.getID());
        registry.register("treeLeaves", ForestryHelper.getPristineInfo("forestry.speciesForest"), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
        // Jungle for Tropical Bees
        registry.register(new ItemInfo("minecraft:leaves:3"), ForestryHelper.getDroneInfo("forestry.speciesTropical"), 0.05f, BlockSieve.MeshType.FLINT.getID());
        registry.register(new ItemInfo("minecraft:leaves:3"), ForestryHelper.getIgnobleInfo("forestry.speciesTropical"), 0.05f, BlockSieve.MeshType.IRON.getID());
        registry.register(new ItemInfo("minecraft:leaves:3"), ForestryHelper.getPristineInfo("forestry.speciesTropical"), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
        // Humus for Marshy Bees
        registry.register(new BlockInfo("forestry:humus"), ForestryHelper.getDroneInfo("forestry.speciesMarshy"), 0.05f, BlockSieve.MeshType.FLINT.getID());
        registry.register(new BlockInfo("forestry:humus"), ForestryHelper.getIgnobleInfo("forestry.speciesMarshy"), 0.05f, BlockSieve.MeshType.IRON.getID());
        registry.register(new BlockInfo("forestry:humus"), ForestryHelper.getPristineInfo("forestry.speciesMarshy"), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
    }

    @Override
    public void registerCrucibleStone(CrucibleRegistry registry) {
        // Melt down honey drops
        registry.register("dropHoney", FluidRegistry.getFluid("for.honey"), 10, new BlockInfo("forestry:bee_combs_0:0"));

        // Melt Down seeds into seed oil, fall back to Thermal's seed oil if forestry's does not exist for some reason.
        // There are no good textures for seeds :/
        if(FluidRegistry.isFluidRegistered("seed.oil"))
            registry.register("listAllseed", FluidRegistry.getFluid("seed.oil"), 10, new BlockInfo(Blocks.SPONGE));
        else if(FluidRegistry.isFluidRegistered("seed_oil"))
            registry.register("listAllseed", FluidRegistry.getFluid("seed_oil"), 10, new BlockInfo(Blocks.SPONGE));

    }

    @Override
    public void registerFluidBlockTransform(FluidBlockTransformerRegistry registry) {
        // Why are TE and Forestry seed oils different ;_;
        if(FluidRegistry.isFluidRegistered("seed.oil"))
            registry.register(FluidRegistry.getFluid("seed.oil"), new ItemInfo("exnihilocreatio:hive:0"), new ItemInfo("exnihilocreatio:hive:1"));
        if(FluidRegistry.isFluidRegistered("seed_oil"))
            registry.register(FluidRegistry.getFluid("seed_oil"), new ItemInfo("exnihilocreatio:hive:0"), new ItemInfo("exnihilocreatio:hive:1"));
    }
}
