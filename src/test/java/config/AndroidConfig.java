package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:android.properties"})
public interface AndroidConfig extends Config {

    AndroidConfig get = ConfigFactory.create(AndroidConfig.class, System.getProperties());

    String device();
    String operatingSystem();
    String application();
}