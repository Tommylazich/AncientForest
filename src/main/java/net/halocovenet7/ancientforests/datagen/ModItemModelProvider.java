package net.halocovenet7.ancientforests.datagen;

import net.halocovenet7.ancientforests.AncientForests;
import net.halocovenet7.ancientforests.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientForests.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
       // simpleItem(ModItems.ITEMS);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AncientForests.MODID,"item/" + item.getId().getPath()));
    }
}
