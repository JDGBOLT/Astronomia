package astronomia.util;

import cpw.mods.fml.common.ModMetadata;
import org.apache.logging.log4j.Logger;

import java.io.File;

public final class AstroMod
{
    public final Logger log;
    public final File jar;
    public final File configDir;
    public final ConfigHandler config;
    public final ModMetadata info;

    public AstroMod(File jar, File configDir, ModMetadata info, Logger log)
    {
        this.log = log;
        this.jar = jar;
        this.info = info;
        this.configDir = configDir;
        this.config = new ConfigHandler(info.version, new File(configDir, info.modId + ".cfg"));
    }
}