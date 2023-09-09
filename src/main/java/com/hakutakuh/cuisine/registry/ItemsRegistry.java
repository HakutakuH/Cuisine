package com.hakutakuh.cuisine.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;
import static com.hakutakuh.cuisine.Cuisine.MOD_ID;

public enum ItemsRegistry{


    ;

    private final String itemid;
    private final Supplier<Item> itemSupplier;
    private Item item;

    ItemsRegistry(String itemid, Supplier<Item> itemSupplier){

        this.itemid = itemid;
        this.itemSupplier = itemSupplier;

    }

    public static void registerAll(){

        for (ItemsRegistry value : values()){

            Registry.register(Registries.ITEM,new Identifier(MOD_ID,value.itemid),value.get());

        }
    }

    public Item get() {

        if (item == null) {

            item = itemSupplier.get();

        }

        return item;

    }
}
