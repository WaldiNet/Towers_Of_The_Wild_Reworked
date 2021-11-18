package waldinet.towers_of_the_wild_reworked.config.screens;

import java.util.Arrays;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;
import waldinet.towers_of_the_wild_reworked.config.tower.*;

public class ConfigScreen
{
    private static ConfigBuilder _builder;

    public static Screen getConfigScreen(Screen parent)
    {
        _builder = ConfigBuilder.create().setParentScreen(parent);
        initConfig();

        return _builder.build();
    }

    private static void initConfig()
    {
        buildConfig();
        buildEntries();
    }

    private static void buildConfig()
    {
        // Base Settings
        _builder.setTitle(new TranslatableText("Towers of the Wild: Reworked"))
            .setDefaultBackgroundTexture(new Identifier("minecraft:textures/block/oak_planks.png"))
            .setSavingRunnable(() -> {
                ConfigManager.getInstance().saveConfig();
            });
    }

    /**
     * Possible builder: https://github.com/shedaniel/cloth-config/tree/v5/common/src/main/java/me/shedaniel/clothconfig2/impl/builders
     * Possible entries: https://github.com/shedaniel/cloth-config/tree/v5/common/src/main/java/me/shedaniel/clothconfig2/gui/entries
     */
    private static void buildEntries()
    {
        ConfigEntryBuilder entry = _builder.entryBuilder();
        ConfigCategory category = _builder.getOrCreateCategory(new TranslatableText("category."+TowersOfTheWildReworked.MOD_ID+".towers"));

        category.addEntry(DerelictGrassTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(DerelictTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(IceTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(JungleTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(OceanTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(OceanWarmTowerConfig.getConfigBuilder(entry).build());
        category.addEntry(RegularTowerConfig.getConfigBuilder(entry).build());

        /**
         * Biome Blacklist
         */
        category.addEntry(
            entry.startStrList(
                new TranslatableText("Biome Blacklist"),
                Arrays.asList(
                    "minecraft:river",
                    "minecraft:frozen_river",
                    "minecraft:beach",
                    "minecraft:stone_shore",
                    "minecraft:snowy_beach",
                    "biomesoplenty:gravel_beach",
                    "biomesoplenty:white_beach"
                )
            ).setTooltip(new TranslatableText("A list of biomes where the towers will not spawn."))
            .setDefaultValue(Arrays.asList("minecraft:river", "minecraft:beach"))
            .build()
        );

        /**
         * Mod integrations
         */
        SubCategoryBuilder modIntegrations = entry.startSubCategory(new TranslatableText("Mod Integrations"));
        // Spawn with Waystone
        modIntegrations.add(
            entry.startBooleanToggle(new TranslatableText("Spawn Waystones on top"), true)
                .setTooltip(new TranslatableText("If the Waytones mod is installed and this is set to true, towers will spawn with a waystone at the top. If the Waystone mod is not installed, this will have no effect."))
                .setDefaultValue(true)
                .build()
        );
        category.addEntry(modIntegrations.build());
    }
}
