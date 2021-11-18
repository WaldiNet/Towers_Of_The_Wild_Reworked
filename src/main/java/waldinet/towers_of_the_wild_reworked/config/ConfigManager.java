package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import net.minecraft.util.ActionResult;

public final class ConfigManager
{
    private static ConfigManager _instance;
    private static TowersOfTheWildReworkedConfig _config;

    public ConfigManager()
    {
        AutoConfig.register(TowersOfTheWildReworkedConfig.class, Toml4jConfigSerializer::new);
        AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).load();
        TowersOfTheWildReworked.LOGGER.info("Config loaded!");
    }

    public static ConfigManager getInstance()
    {
        if (_instance == null) {
            _instance = new ConfigManager();
        }

        return _instance;
    }

    public TowersOfTheWildReworkedConfig getConfig()
    {
        return AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).getConfig();
    }

    public void saveConfig()
    {
        // AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).registerLoadListener((configHolder, configObject) -> {
        //     _config = configObject;
        //     return ActionResult.PASS;
        // });

        AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).save();
    }
}
