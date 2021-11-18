package waldinet.towers_of_the_wild_reworked.config.tower;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.text.TranslatableText;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;

public class DerelictTowerConfig
{
    private boolean enabled = true;
    private int rarity = 72;

    public static SubCategoryBuilder getConfigBuilder(ConfigEntryBuilder entry)
    {
        SubCategoryBuilder subCategory = entry.startSubCategory(new TranslatableText("Derelict Tower"));
        // Enable Tower
        subCategory.add(
            entry.startBooleanToggle(new TranslatableText("Enabled"), ConfigManager.getInstance().getConfig().derelictTower.enabled)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictTower.enabled = newValue)
                .build()
        );

        // Rarity
        subCategory.add(
            entry.startIntSlider(new TranslatableText("Rarity"), ConfigManager.getInstance().getConfig().derelictTower.rarity, 3, 200)
                .setTooltip(new TranslatableText("How rarely this tower type will spawn (low: common, high: rare)"))
                .setDefaultValue(72)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictTower.rarity = newValue)
                .build()
        );

        return subCategory;
    }
}
