package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:ios.properties"})
public interface IosConfig extends Config {

    IosConfig get = ConfigFactory.create(IosConfig.class, System.getProperties());

    String device();
    String operatingSystem();
    String application();
}