package com.hakutakuh.cuisine.client;

import com.hakutakuh.cuisine.registry.BlocksRegistry;
import net.fabricmc.api.ClientModInitializer;

public class CuisineClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlocksRegistry.registerRenderLayer();

    }
}
