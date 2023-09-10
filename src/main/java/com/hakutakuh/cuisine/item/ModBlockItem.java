package com.hakutakuh.cuisine.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ModBlockItem extends BlockItem {

    public ModBlockItem(Block block) {
        super(block, new ModItemSetting());
    }

    public ModBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

}