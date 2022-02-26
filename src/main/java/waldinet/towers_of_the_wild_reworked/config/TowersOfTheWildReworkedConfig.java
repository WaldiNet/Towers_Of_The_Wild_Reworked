package waldinet.towers_of_the_wild_reworked.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import waldinet.towers_of_the_wild_reworked.TowersOfTheWildReworked;

@Config(name = TowersOfTheWildReworked.MOD_ID)
public class TowersOfTheWildReworkedConfig implements ConfigData
{
    @ConfigEntry.Gui.CollapsibleObject
    public RegularTowerSettings regularTower = new RegularTowerSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public DerelictTowerSettings derelictTower = new DerelictTowerSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public DerelictGrassTowerSettings derelictGrassTower = new DerelictGrassTowerSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public IceTowerSettings iceTower = new IceTowerSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public JungleTowerSettings jungleTower = new JungleTowerSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public OceanTowerBaseSettings oceanTower = new OceanTowerBaseSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public OceanWarmTowerBaseSettings oceanWarmTower = new OceanWarmTowerBaseSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public ModSupportSettings modSupport = new ModSupportSettings();

    @ConfigEntry.Gui.CollapsibleObject
    public DebuggingSettings debugging = new DebuggingSettings();

    public static class RegularTowerSettings
    {
        public boolean active = true;
        public int spacing = 72;
        public int separation = 8;
    }

    public static class DerelictTowerSettings
    {
        public boolean active = true;
        public int spacing = 35;
        public int separation = 8;
    }

    public static class DerelictGrassTowerSettings
    {
        public boolean active = true;
        public int spacing = 35;
        public int separation = 8;
    }

    public static class IceTowerSettings
    {
        public boolean active = true;
        public int spacing = 35;
        public int separation = 8;
    }

    public static class JungleTowerSettings
    {
        public boolean active = true;
        public int spacing = 38;
        public int separation = 8;
    }

    public static class OceanTowerBaseSettings
    {
        public boolean active = true;
        public int spacing = 38;
        public int separation = 8;
    }

    public static class OceanWarmTowerBaseSettings
    {
        public boolean active = true;
        public int spacing = 72;
        public int separation = 8;
    }

    public static class ModSupportSettings
    {
        public boolean enableWaystones = true;
    }

    public static class DebuggingSettings
    {
        public boolean enableLogs = false;
        public boolean logConfig = false;
    }
}
