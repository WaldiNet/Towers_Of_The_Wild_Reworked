package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import net.minecraft.util.ActionResult;

public final class ConfigManager
{
    private static ConfigManager _instance = null;
    private static TowersOfTheWildReworkedConfig _config = null;

    public ConfigManager()
    {
        AutoConfig.register(TowersOfTheWildReworkedConfig.class, Toml4jConfigSerializer::new);

        AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).registerLoadListener((configHolder, newData) -> {
            _config = newData;
            TowersOfTheWildReworked.LOGGER.info(newData);
            return ActionResult.SUCCESS;
        });

        AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).registerLoadListener((configHolder, data) -> {
            _config = data;
            TowersOfTheWildReworked.LOGGER.info(data);
            return ActionResult.SUCCESS;
        });

        saveConfig();

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
        if (_config == null) {
            _config = AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).getConfig();
        }
        return _config;
    }

    public void saveConfig()
    {
        AutoConfig.getConfigHolder(TowersOfTheWildReworkedConfig.class).save();
    }
}
