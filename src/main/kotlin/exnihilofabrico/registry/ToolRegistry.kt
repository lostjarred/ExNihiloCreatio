package exnihilofabrico.registry

import exnihilofabrico.api.crafting.Lootable
import exnihilofabrico.api.registry.IToolRegistry
import exnihilofabrico.util.test
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import java.util.*
import java.util.function.Predicate

data class ToolRegistry(val registry: MutableMap<Predicate<ItemStack>, MutableList<Lootable>> = HashMap()): IToolRegistry {
    override fun registerDrops(target: Predicate<ItemStack>, loot: Collection<Lootable>) {
        if(!registry.containsKey(target))
            registry[target] = mutableListOf()
        registry[target]?.addAll(loot)
    }

    override fun isRegistered(target: ItemConvertible) = registry.keys.any { it.test(target) }

    override fun getResult(target: ItemConvertible, rand: Random): MutableList<ItemStack> {
        return getAllResults(target)
            .filter { loot-> loot.chance.any {it > rand.nextDouble() }}
            .map{it.stack.copy()}.toMutableList()
    }
    override fun getAllResults(target: ItemConvertible) =
        registry.filter { it.key.test(target) }.values.flatten()

}