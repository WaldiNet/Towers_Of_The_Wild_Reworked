package waldinet.towers_of_the_wild_reworked.config.tower;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.SubCategoryListEntry;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.text.TranslatableText;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;

public class DerelictTowerConfig
{
    public boolean active = true;
    public int spacing = 72;

    public static SubCategoryListEntry getConfigBuilder(ConfigEntryBuilder entry)
    {
        SubCategoryBuilder subCategory = entry.startSubCategory(new TranslatableText("config.towers_of_the_wild_reworked.derelict"));

        // Enable Tower
        subCategory.add(
            entry.startBooleanToggle(new TranslatableText("config.towers_of_the_wild_reworked.tower_active"), ConfigManager.getInstance().getConfig().derelictTower.active)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictTower.active = newValue)
                .requireRestart()
                .build()
        );

        // Spacing
        subCategory.add(
            entry.startIntSlider(new TranslatableText("config.towers_of_the_wild_reworked.tower_spacing"), ConfigManager.getInstance().getConfig().derelictTower.spacing, 3, 200)
                .setTooltip(new TranslatableText("config.towers_of_the_wild_reworked.tower_spacing.tooltip"))
                .setDefaultValue(72)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictTower.spacing = newValue)
                .requireRestart()
                .build()
        );

        return subCategory.build();
    }
}
