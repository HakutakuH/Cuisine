package com.hakutakuh.cuisine.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.function.Supplier;

import static com.hakutakuh.cuisine.Cuisine.MOD_ID;

public enum BlocksRegistry{

    SCULK_NYLIUM("sculk_nylium", () -> new NyliumBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(Instrument.BASEDRUM).requiresTool().strength(0.4F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly()),false),
    SCULK_FUNGUS("sculk_fungus", () -> new FungusBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).breakInstantly().noCollision().sounds(BlockSoundGroup.FUNGUS).pistonBehavior(PistonBehavior.DESTROY), TreeConfiguredFeatures.CRIMSON_FUNGUS_PLANTED,SCULK_NYLIUM.get()),true),
    POTTED_SCULK_FUNGUS("potted_sculk_fungus", () -> new FlowerPotBlock(SCULK_FUNGUS.get(),AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)),true),
    ;

    private final String blockid;
    private final Supplier<Block> blockSupplier;
    private final boolean isCutout;
    private Block block;

    BlocksRegistry(String blockid, Supplier<Block> blockSupplier, boolean isCutout){

        this.blockid = blockid;
        this.blockSupplier = blockSupplier;
        this.isCutout = isCutout;
    }

    public static void registerAll() {
        for (BlocksRegistry value : values()) {
            Block block = value.get();
            Registry.register(Registries.BLOCK, new Identifier(MOD_ID, value.blockid), block);
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        for (BlocksRegistry value : values()) {
            if (value.isCutout) {
                BlockRenderLayerMap.INSTANCE.putBlock(value.get(), RenderLayer.getCutout());
            }
        }
    }

    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }
}
