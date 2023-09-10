package com.hakutakuh.cuisine.registry;

import static com.hakutakuh.cuisine.Cuisine.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.function.Supplier;

public enum BiomeFeaturesRegistry {

    SCULK_FUNGUS_PLANTED("sculk_fungus_planted", () -> new ),
    ;
    private final String biomefeatureid;
    private final Supplier<Feature<? extends FeatureConfig>> featureSupplier;
    private Feature<? extends FeatureConfig> feature;

    BiomeFeaturesRegistry(String biomefeatureid, Supplier<Feature<? extends FeatureConfig>> featureSupplier) {
        this.biomefeatureid = biomefeatureid;
        this.featureSupplier = featureSupplier;
    }


    public static void registerAll() {
        for (BiomeFeaturesRegistry value : values()) {
            Registry.register(Registries.FEATURE, new Identifier(MOD_ID, value.biomefeatureid), value.featureSupplier.get());
        }
    }

    public Feature<? extends FeatureConfig> get() {
        if (feature == null) {
            feature = featureSupplier.get();
        }
        return feature;
    }
}
