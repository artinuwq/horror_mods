package net.mcreator.horrormods.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormods.HorrorModsMod;

import java.util.Map;
import java.util.Collection;

public class HarddreamsProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency world for procedure Harddreams!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency x for procedure Harddreams!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency y for procedure Harddreams!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency z for procedure Harddreams!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrorModsMod.LOGGER.warn("Failed to load dependency entity for procedure Harddreams!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double time = 0;
		if (world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z))) {
			if (!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.INVISIBILITY)
								return true;
						}
					}
					return false;
				}
			}.check(entity)) && true) {
				if (10 == time) {
					entity.attackEntityFrom(DamageSource.MAGIC, (float) 1);
					time = 0;
				} else {
					time = (1 + time);
				}
			}
		}
	}
}
