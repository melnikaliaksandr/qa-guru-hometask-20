package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:config.properties"})
public interface ProjectConfig extends Config {

    ProjectConfig get = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    String hubUrl();
    String sessionUrl();
    String user();
    String key();
}