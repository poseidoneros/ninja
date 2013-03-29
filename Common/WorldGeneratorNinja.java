

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorNinja implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
		
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
		
	}

	private void generateSurface(World world, Random random, int chunkX,
			int chunkZ) {
		for(int i = 0; i < 8; i++){
			int xcoord = chunkX + random.nextInt(16);
			int ycoord = random.nextInt(20);
			int zcoord = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(ninja.OsmiumOre.blockID, 5)).generate(world, random, xcoord, ycoord, zcoord);
		}
		
		for(int i = 0; i < 15; i++){
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(46);
			int z = chunkZ + random.nextInt(16);
			
			(new WorldGenMinable(ninja.GlowCrystalOre.blockID, 10)).generate(world, random, x, y, z);
		}
		
	}

	private void generateNether(World world, Random random, int chunkX,
			int chunkZ) {
		
		
	}

}
