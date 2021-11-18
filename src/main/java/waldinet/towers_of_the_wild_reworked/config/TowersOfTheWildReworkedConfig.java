package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import waldinet.towers_of_the_wild_reworked.config.tower.*;

@Config(name = "towers_of_the_wild_reworked")
@Environment(EnvType.CLIENT)
public class TowersOfTheWildReworkedConfig implements ConfigData
{
    @ConfigEntry.Category("derelict_grass_tower")
    public DerelictGrassTowerConfig derelictGrassTower = new DerelictGrassTowerConfig();

    @ConfigEntry.Category("derelict_tower")
    public DerelictTowerConfig derelictTower = new DerelictTowerConfig();

    @ConfigEntry.Category("ice_tower")
    public IceTowerConfig iceTower = new IceTowerConfig();

    @ConfigEntry.Category("jungle_tower")
    public JungleTowerConfig jungleTower = new JungleTowerConfig();

    @ConfigEntry.Category("ocean_tower")
    public OceanTowerConfig oceanTower = new OceanTowerConfig();

    @ConfigEntry.Category("ocean_warm_tower")
    public OceanWarmTowerConfig oceanWarmTower = new OceanWarmTowerConfig();

    @ConfigEntry.Category("regular_tower")
    public RegularTowerConfig regularTower = new RegularTowerConfig();
}
