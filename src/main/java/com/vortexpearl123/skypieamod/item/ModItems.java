package com.vortexpearl123.skypieamod.item;

import com.vortexpearl123.skypieamod.SkypieaMod; //my skypiea mod which i need to access the MODID
import net.minecraft.core.registries.BuiltInRegistries; //accessing vanilla minecraft built in registries.
import net.minecraft.world.item.Item; //minecraft registers all items inside the "Item" class
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister; //deffered registers to handle possible problems.

public class ModItems {


    //DeferredRegister.Items is a subclass that is a special register specifically for deffered item types (which is what we're returning)
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SkypieaMod.MODID);


    public static final DeferredItem<Item> DIAL = ITEMS.register("dial", ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HEAT_DIAL = ITEMS.register("heat_dial", () -> new Item(new Item.Properties()));


    //now we need a register method to register our item components.
    public static void register(IEventBus IEB){
        ITEMS.register(IEB);
    }

}
