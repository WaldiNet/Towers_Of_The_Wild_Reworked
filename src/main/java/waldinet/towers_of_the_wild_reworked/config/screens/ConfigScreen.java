package waldinet.towers_of_the_wild_reworked.config.screens;

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
        _builder.setTitle(new TranslatableText("mod.towers_of_the_wild_reworked.name"))
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

        category.addEntry(DerelictGrassTowerConfig.getConfigBuilder(entry));
        category.addEntry(DerelictTowerConfig.getConfigBuilder(entry));
        category.addEntry(IceTowerConfig.getConfigBuilder(entry));
        category.addEntry(JungleTowerConfig.getConfigBuilder(entry));
        category.addEntry(OceanTowerConfig.getConfigBuilder(entry));
        category.addEntry(OceanWarmTowerConfig.getConfigBuilder(entry));
        category.addEntry(RegularTowerConfig.getConfigBuilder(entry));

        // subCategory.add(
        //     entry.startStrList(
        //         new TranslatableText("config.towers_of_the_wild_reworked.biome_blacklist"),
        //         Arrays.asList(
        //             "minecraft:river",
        //             "minecraft:frozen_river",
        //             "minecraft:beach",
        //             "minecraft:stone_shore",
        //             "minecraft:snowy_beach",
        //             "biomesoplenty:gravel_beach",
        //             "biomesoplenty:white_beach"
        //         )
        //     ).setTooltip(new TranslatableText("config.towers_of_the_wild_reworked.biome_blacklist.tooltip"))
        //     .setDefaultValue(Arrays.asList("minecraft:river", "minecraft:beach"))
        //     .build()
        // );

        /**
         * Mod integrations
         */
        SubCategoryBuilder modIntegrations = entry.startSubCategory(new TranslatableText("config.towers_of_the_wild_reworked.mod_integration"));
        // Spawn with Waystone
        modIntegrations.add(
            entry.startBooleanToggle(new TranslatableText("config.towers_of_the_wild_reworked.mod_integration.waystones"), true)
                .setTooltip(new TranslatableText("config.towers_of_the_wild_reworked.mod_integration.waystones.tooltip"))
                .setDefaultValue(true)
                .build()
        );
        category.addEntry(modIntegrations.build());
    }
}
