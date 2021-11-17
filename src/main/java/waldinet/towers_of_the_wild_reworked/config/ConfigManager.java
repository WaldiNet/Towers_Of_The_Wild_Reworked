package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public final class ConfigManager
{
    private static ConfigManager _instance;

    public ConfigManager()
    {
        AutoConfig.register(TowersOfTheWildReworkedConfig.class, Toml4jConfigSerializer::new); // Toml
        // AutoConfig.register(TowersOfTheWildReworkedConfig.class, GsonConfigSerializer::new); // Json
        // AutoConfig.register(TowersOfTheWildReworkedConfig.class, JanksonConfigSerializer::new); // Json5
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
}
