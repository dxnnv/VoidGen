package de.xtkq.voidgen;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public final class VoidGen extends JavaPlugin {

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, String id) {
        return new VoidChunkGenerator();
    }

    private static class VoidChunkGenerator extends ChunkGenerator {
        @Override
        public Location getFixedSpawnLocation(@NotNull World world, @NotNull Random random) {
            return new Location(world, 0.5d, 65d, 0.5d);
        }

        @Override
        public void generateBedrock(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
            final int x = 0, y = 64, z = 0;

            if ((x >= chunkX * 16) && (x < (chunkX + 1) * 16))
                if ((z >= chunkZ * 16) && (z < (chunkZ + 1) * 16))
                    if (chunkData.getType(x, y, z) == Material.AIR)
                        chunkData.setBlock(x, y, z, Material.BEDROCK);
        }
    }
}