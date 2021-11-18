package waldinet.towers_of_the_wild_reworked.config.tower;

import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.text.TranslatableText;
import waldinet.towers_of_the_wild_reworked.config.ConfigManager;

public class DerelictGrassTowerConfig
{
    public boolean enabled = true;
    public int rarity = 40;
    
    public static SubCategoryBuilder getConfigBuilder(ConfigEntryBuilder entry)
    {
        SubCategoryBuilder subCategory = entry.startSubCategory(new TranslatableText("Derelict Grass Tower"));
        // Enable Tower
        subCategory.add(
            entry.startBooleanToggle(new TranslatableText("Enabled"), ConfigManager.getInstance().getConfig().derelictGrassTower.enabled)
                .setDefaultValue(true)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictGrassTower.enabled = newValue)
                .build()
        );

        // Rarity
        subCategory.add(
            entry.startIntSlider(new TranslatableText("Rarity"), ConfigManager.getInstance().getConfig().derelictGrassTower.rarity, 3, 200)
                .setTooltip(new TranslatableText("How rarely this tower type will spawn (low: common, high: rare)"))
                .setDefaultValue(40)
                .setSaveConsumer(newValue -> ConfigManager.getInstance().getConfig().derelictGrassTower.rarity = newValue)
                .build()
        );

        return subCategory;
    }
}
