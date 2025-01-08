package com.vortexpearl123.skypieamod.blocks;

import com.vortexpearl123.skypieamod.SkypieaMod;
import com.vortexpearl123.skypieamod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SkypieaMod.MODID);

    //BLOCKS
    public static final DeferredBlock<Block> CLOUDBLOCK = registerBlock("cloud_block",
            () -> new Block(
                    BlockBehaviour.Properties.of()
                    .strength(0.55f).sound(SoundType.SNOW)
            ));
















    //METHODS TO REGISTER
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block); //create and register the block
        registerBlockItem(name, toReturn); //register the block item associated with it
        return toReturn; //return me the deferredBlock
    }
    //very weird syntax. "public static" defines a public identifier which belongs to the class ModBlocks
    // <T extends Block> is defining a generic child which extends the Block class. The method must apply to generics of type T which extends the class Block.
    // remember that in formal mathematics, every set is a subset of itself, this means this method can also be applied to instances of type "Block"
    // void is the return type
    // registerBlockItem(String name, DeferredBlock<T> block) is the method's name and parameters.
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        //the () -> {} is a concise way of defining an anonymous function. It's supposed to be a lambda expression
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus ieb){
        BLOCKS.register(ieb);
        //you're taking an event buss and making the BLOCKS deferedRegister, register it. This makes the BLOCKS deferedRegister listen for events on the bus
    }
}
