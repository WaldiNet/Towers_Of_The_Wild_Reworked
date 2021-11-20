package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import waldinet.towers_of_the_wild_reworked.config.tower.*;

@Config(name = "towers_of_the_wild_reworked")
public class TowersOfTheWildReworkedConfig implements ConfigData
{
    @ConfigEntry.Category("derelict_grass_tower")
    @ConfigEntry.Gui.TransitiveObject
    public DerelictGrassTowerConfig derelictGrassTower = new DerelictGrassTowerConfig();

    @ConfigEntry.Category("derelict_tower")
    @ConfigEntry.Gui.TransitiveObject
    public DerelictTowerConfig derelictTower = new DerelictTowerConfig();

    @ConfigEntry.Category("ice_tower")
    @ConfigEntry.Gui.TransitiveObject
    public IceTowerConfig iceTower = new IceTowerConfig();

    @ConfigEntry.Category("jungle_tower")
    @ConfigEntry.Gui.TransitiveObject
    public JungleTowerConfig jungleTower = new JungleTowerConfig();

    @ConfigEntry.Category("ocean_tower")
    @ConfigEntry.Gui.TransitiveObject
    public OceanTowerConfig oceanTower = new OceanTowerConfig();

    @ConfigEntry.Category("ocean_warm_tower")
    @ConfigEntry.Gui.TransitiveObject
    public OceanWarmTowerConfig oceanWarmTower = new OceanWarmTowerConfig();

    @ConfigEntry.Category("regular_tower")
    @ConfigEntry.Gui.TransitiveObject
    public RegularTowerConfig regularTower = new RegularTowerConfig();
}
