package crazypants.enderio.conduits.refinedstorage;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.tuple.Triple;

import com.enderio.core.common.util.NNList;

import crazypants.enderio.api.addon.IEnderIOAddon;
import crazypants.enderio.base.Log;
import crazypants.enderio.base.config.recipes.RecipeFactory;
import crazypants.enderio.conduits.refinedstorage.init.ConduitRefinedStorageObject;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = EnderIOConduitsRefinedStorage.MODID, name = EnderIOConduitsRefinedStorage.MOD_NAME, version = EnderIOConduitsRefinedStorage.VERSION, dependencies = EnderIOConduitsRefinedStorage.DEPENDENCIES)
@EventBusSubscriber
public class EnderIOConduitsRefinedStorage implements IEnderIOAddon {

  public static final @Nonnull String MODID = "enderioconduitsrefinedstorage";
  public static final @Nonnull String DOMAIN = "enderio";
  public static final @Nonnull String MOD_NAME = "Ender IO Conduits Refined Storage";
  public static final @Nonnull String VERSION = "@VERSION@";

  private static final @Nonnull String DEFAULT_DEPENDENCIES = "after:" + crazypants.enderio.base.EnderIO.MODID;
  public static final @Nonnull String DEPENDENCIES = DEFAULT_DEPENDENCIES;

  @EventHandler
  public static void init(@Nonnull FMLPreInitializationEvent event) {
    if (isLoaded()) {
      Log.warn("Refined Storage conduits loaded. Let your networks connect!");
    } else {
      Log.warn("Refined Storage conduits NOT loaded. Refined Storage is not installed");
    }
  }

  @EventHandler
  public static void init(FMLInitializationEvent event) {
    if (isLoaded()) {
    }
  }

  @EventHandler
  public static void init(FMLPostInitializationEvent event) {
    if (isLoaded()) {
    }
  }

  @SubscribeEvent(priority = EventPriority.HIGHEST)
  public static void registerConduits(@Nonnull RegistryEvent.Register<Block> event) {
    if (isLoaded()) {
      ConduitRefinedStorageObject.registerBlocksEarly(event);
    }
  }

  @Override
  @Nonnull
  public NNList<Triple<Integer, RecipeFactory, String>> getRecipeFiles() {
    if (isLoaded()) {
      return new NNList<>(Triple.of(2, null, "conduits-refined-storage"));
    }
    return NNList.emptyList();
  }

  public static boolean isLoaded() {
    return Loader.isModLoaded("refinedstorage");
  }

}
