package net.mcreator.horrormods.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.horrormods.HorrorModsMod;

import java.util.Map;

public class HarddreamsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency entity for procedure Harddreams!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double time = 0;
		if (true) {
			if (10 == time) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
				time = 0;
			} else {
				time = (1 + time);
			}
		}
	}
}
