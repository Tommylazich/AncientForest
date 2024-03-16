package net.halocovenet7.ancientforests.block.custom;

import net.halocovenet7.ancientforests.AncientForests;
import net.halocovenet7.ancientforests.Util.ModTags;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class ModWoodTypes {

    public static final WoodType OAK_BRANCH = register(new WoodType(AncientForests.MODID + ":oak_branch", ModBlockSetType.OAK_BRANCH));

}
