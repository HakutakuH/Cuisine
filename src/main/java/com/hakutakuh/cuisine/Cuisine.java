package com.hakutakuh.cuisine;

import com.hakutakuh.cuisine.registry.BlocksRegistry;
import com.hakutakuh.cuisine.registry.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cuisine implements ModInitializer{

    public static final String MOD_ID = "cuisine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        LOGGER.info("Cuisine!");

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();
    }
}
