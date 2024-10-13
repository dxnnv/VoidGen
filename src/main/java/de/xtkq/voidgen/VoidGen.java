package de.xtkq.voidgen;

import de.xtkq.voidgen.generator.instances.VoidChunkGen;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidGen extends JavaPlugin {
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new VoidChunkGen(this, id);
    }
}
