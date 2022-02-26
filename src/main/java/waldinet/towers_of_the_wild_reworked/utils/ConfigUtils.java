package waldinet.towers_of_the_wild_reworked.utils;

import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;
import waldinet.towers_of_the_wild_reworked.config.TowersOfTheWildReworkedConfig;

public class ConfigUtils
{
    public static void Log(String message)
	{
		if (!TowersOfTheWildReworked.CONFIG.debugging.enableLogs) {
			return;
		}
		TowersOfTheWildReworked.LOGGER.info(String.format("[Towers of the Wild: Reworked] %s", message));
	}

    public static void logConfig()
    {
        TowersOfTheWildReworkedConfig _config = TowersOfTheWildReworked.CONFIG;

        Log("#########################");
        Log("Current Config");
        Log("=========================");

        Log(String.format("regular:active >> %s", _config.regularTower.active));
        Log(String.format("regular:spacing >> %s", _config.regularTower.spacing));
        Log(String.format("regular:separation >> %s", _config.regularTower.separation));
        Log("-------------------------");
        Log(String.format("derelict:active >> %s", _config.derelictTower.active));
        Log(String.format("derelict:spacing >> %s", _config.derelictTower.spacing));
        Log(String.format("regular:separation >> %s", _config.derelictTower.separation));
        Log("-------------------------");
        Log(String.format("derelict_grass:active >> %s", _config.derelictGrassTower.active));
        Log(String.format("derelict_grass:spacing >> %s", _config.derelictGrassTower.spacing));
        Log(String.format("derelict_grass:separation >> %s", _config.derelictGrassTower.separation));
        Log("-------------------------");
        Log(String.format("ice:active >> %s", _config.iceTower.active));
        Log(String.format("ice:spacing >> %s", _config.iceTower.spacing));
        Log(String.format("ice:separation >> %s", _config.iceTower.separation));
        Log("-------------------------");
        Log(String.format("jungle:active >> %s", _config.jungleTower.active));
        Log(String.format("jungle:spacing >> %s", _config.jungleTower.spacing));
        Log(String.format("jungle:separation >> %s", _config.jungleTower.separation));
        Log("-------------------------");
        Log(String.format("ocean:active >> %s", _config.oceanTower.active));
        Log(String.format("ocean:spacing >> %s", _config.oceanTower.spacing));
        Log(String.format("ocean:separation >> %s", _config.oceanTower.separation));
        Log("-------------------------");
        Log(String.format("ocean_warm:active >> %s", _config.oceanWarmTower.active));
        Log(String.format("ocean_warm:spacing >> %s", _config.oceanWarmTower.spacing));
        Log(String.format("ocean_warm:separation >> %s", _config.oceanWarmTower.separation));
        Log("-------------------------");
        Log(String.format("debugging:enableLogs >> %s", _config.debugging.enableLogs));
        Log(String.format("debugging:logConfig >> %s", _config.debugging.logConfig));
        Log("#########################");
    }    
}
