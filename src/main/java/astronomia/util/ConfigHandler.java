package astronomia.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import java.io.File;

public class ConfigHandler
{
    public final Configuration config;
    public final File file;
    public final String version;

    public ConfigHandler(String version, File configFile)
    {
        this.version = version;
        this.file = configFile;
        this.config = new Configuration(configFile, this.version, true);
        config.load();
    }

    public void load()
    {
        config.load();
    }

    public void save()
    {
        config.save();
    }

    // Raw property functions
    public Property getProperty(String category, String key, boolean defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, boolean[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, int defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, int[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, double defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, double[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, String defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }
    public Property getProperty(String category, String key, String[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue));
    }

    // Boolean Shortcuts
    public boolean get(String category, String key, boolean defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getBoolean(defaultValue);
    }
    public boolean get(String category, String key, boolean defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getBoolean(defaultValue);
    }
    public boolean[] get(String category, String key, boolean[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getBooleanList();
    }
    public boolean[] get(String category, String key, boolean[] defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getBooleanList();
    }

    // Integer shortcuts
    public int get(String category, String key, int defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getInt();
    }
    public int get(String category, String key, int defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getInt();
    }
    public int[] get(String category, String key, int[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getIntList();
    }
    public int[] get(String category, String key, int[] defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getIntList();
    }
    public int get(String category, String key, int defaultValue, int minValue, int maxValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue, minValue, maxValue), minValue, maxValue).getInt();
    }
    public int get(String category, String key, int defaultValue, String comment, int minValue, int maxValue)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue, minValue, maxValue), minValue, maxValue).getInt();
    }
    public int[] get(String category, String key, int[] defaultValue, int minValue, int maxValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue, minValue, maxValue), minValue, maxValue).getIntList();
    }
    public int[] get(String category, String key, int[] defaultValue, String comment, int minValue, int maxValue)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue, minValue, maxValue), minValue, maxValue).getIntList();
    }

    // Double shortcuts
    public double get(String category, String key, double defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getDouble();
    }
    public double get(String category, String key, double defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getDouble();
    }
    public double[] get(String category, String key, double[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getDoubleList();
    }
    public double[] get(String category, String key, double[] defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getDoubleList();
    }
    public double get(String category, String key, double defaultValue, double minValue, double maxValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue, minValue, maxValue), minValue, maxValue).getDouble();
    }
    public double get(String category, String key, double defaultValue, String comment, double minValue, double maxValue)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue, minValue, maxValue), minValue, maxValue).getDouble();
    }
    public double[] get(String category, String key, double[] defaultValue, double minValue, double maxValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue, minValue, maxValue), minValue, maxValue).getDoubleList();
    }
    public double[] get(String category, String key, double[] defaultValue, String comment, double minValue, double maxValue)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue, minValue, maxValue), minValue, maxValue).getDoubleList();
    }

    // String shortcuts
    public String get(String category, String key, String defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getString();
        //return config.get(category, key, defaultValue, null).getString();
    }
    public String get(String category, String key, String defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getString();
    }
    public String[] get(String category, String key, String[] defaultValue)
    {
        return config.get(category, key, defaultValue, comment(key, defaultValue)).getStringList();
    }
    public String[] get(String category, String key, String[] defaultValue, String comment)
    {
        return config.get(category, key, defaultValue, comment(comment, defaultValue)).getStringList();
    }
    public boolean hasChanged()
    {
        return config.hasChanged();
    }
    private String comment(String comment, Object defaultValue)
    {
        return comment + " [default: " + defaultValue + "]";
    }
    private String comment(String comment, Object defaultValue, Object min, Object max)
    {
        return comment + " [range: " + min + "~" + max + ", default: " + defaultValue + "]";
    }
}
