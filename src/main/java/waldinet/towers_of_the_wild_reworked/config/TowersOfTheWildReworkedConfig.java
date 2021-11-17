package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import waldinet.towers_of_the_wild_reworked.config.tower.DerelictGrassTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.DerelictTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.IceTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.JungleTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.OceanTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.OceanWarmTowerConfig;
import waldinet.towers_of_the_wild_reworked.config.tower.RegularTowerConfig;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@Config(name = "towers_of_the_wild_reworked")
@Environment(EnvType.CLIENT)
public class TowersOfTheWildReworkedConfig implements ConfigData
{
    @ConfigEntry.Category("derelict_grass_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public DerelictGrassTowerConfig derelictGrassTower = new DerelictGrassTowerConfig();

    @ConfigEntry.Category("derelict_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public DerelictTowerConfig derelictTower = new DerelictTowerConfig();

    @ConfigEntry.Category("ice_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public IceTowerConfig iceTower = new IceTowerConfig();

    @ConfigEntry.Category("jungle_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public JungleTowerConfig jungleTower = new JungleTowerConfig();

    @ConfigEntry.Category("ocean_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public OceanTowerConfig oceanTower = new OceanTowerConfig();

    @ConfigEntry.Category("ocean_warm_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public OceanWarmTowerConfig oceanWarmTower = new OceanWarmTowerConfig();

    @ConfigEntry.Category("regulkarregular_tower")
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Gui.CollapsibleObject
    public RegularTowerConfig regularTower = new RegularTowerConfig();
}
