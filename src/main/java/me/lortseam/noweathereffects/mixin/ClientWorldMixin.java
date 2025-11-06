package me.lortseam.noweathereffects.mixin;

import me.lortseam.noweathereffects.NoWeatherEffects;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin extends World {

    protected ClientWorldMixin(
            MutableWorldProperties properties,
            RegistryKey<World> registryRef,
            DynamicRegistryManager registryManager,
            RegistryEntry<DimensionType> dimensionEntry,
            boolean isClient,
            boolean debugWorld,
            long seed,
            int maxChainedNeighborUpdates
    ) {
        super(properties, registryRef, registryManager, dimensionEntry, isClient, debugWorld, seed, maxChainedNeighborUpdates);
    }

    @Override
    public float getRainGradient(float tickDelta) {
        if (NoWeatherEffects.isEnabled()) {
            return 0.0F;
        }
        return super.getRainGradient(tickDelta);
    }

    @Override
    public float getThunderGradient(float tickDelta) {
        if (NoWeatherEffects.isEnabled()) {
            return 0.0F;
        }
        return super.getThunderGradient(tickDelta);
    }
}