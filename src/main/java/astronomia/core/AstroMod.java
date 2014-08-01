package astronomia.core;

import cofh.util.ConfigHandler;
import cpw.mods.fml.common.ModMetadata;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

import java.io.File;

public final class AstroMod {

	public final Logger log;
	public final File jar;
	public final File configDir;
	public final ConfigHandler config;
	public final ModMetadata info;

	public AstroMod(File jar, File configDir, ModMetadata info, Logger log, File configFile) {

		this.log = log;
		this.jar = jar;
		this.info = info;
		this.configDir = configDir;
		this.config = new ConfigHandler(this.info.version);
		this.config.setConfiguration(new Configuration(configFile, this.info.version));
	}
}