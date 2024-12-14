package configs;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/android.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOSVersion();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
