package net.halocovenet7.ancientforests.block;

import net.halocovenet7.ancientforests.AncientForests;
import net.halocovenet7.ancientforests.block.custom.BranchBlock;
import net.halocovenet7.ancientforests.block.custom.ModWoodTypes;
import net.halocovenet7.ancientforests.block.custom.SpottedBlock;
import net.halocovenet7.ancientforests.items.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.GRASS;
import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AncientForests.MODID);

    public static final RegistryObject<Block> OAK_BRANCH = registerBlock("oak_branch",
            () -> new BranchBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_ROOTS).sound(SoundType.GRASS).ignitedByLava()));

    public static final RegistryObject<Block> LEAF_LITTER = registerBlock("leaf_litter",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).sound(SoundType.GRASS).noCollission().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> SPOTTED_GRASS = registerBlock("spotted_grass",
            () -> new PinkPetalsBlock(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).sound(SoundType.GRASS).noCollission().pushReaction(PushReaction.DESTROY)));


    @OnlyIn(Dist.CLIENT)
    public static void setRenderTypes() {
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();

        ItemBlockRenderTypes.setRenderLayer(LEAF_LITTER.get(), cutoutRenderType);
        ItemBlockRenderTypes.setRenderLayer(OAK_BRANCH.get(), cutoutRenderType);
        ItemBlockRenderTypes.setRenderLayer(SPOTTED_GRASS.get(), cutoutRenderType);

    }
    @OnlyIn(Dist.CLIENT)
    public static void registerWoodTypes()
    {
        Sheets.addWoodType(ModWoodTypes.OAK_BRANCH);

    }


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
