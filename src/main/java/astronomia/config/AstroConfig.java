package astronomia.config;

import astronomia.Astronomia;
import astronomia.reference.AstroProps;
import astronomia.util.ConfigHandler;
import net.minecraftforge.common.config.Configuration;

public class AstroConfig
{
    private final ConfigHandler config = Astronomia.mod.config;
    public class General
    {
        public static final String category = Configuration.CATEGORY_GENERAL;
    } final General general = new General();
}
