package com.hakutakuh.cuisine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ModItemSetting extends FabricItemSettings{

    public static FabricItemSettings base() {
        return new ModItemSetting();
    }

    ModItemSetting(){
        super();
    }
}
