package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String
    PLATFORM_IOS = "ios",
    PLATFORM_ANDROID = "android",
    PLATFORM_MOBILE_WEB = "mobile_web",
    APPIUM_URL = "http://127.0.0.1:4723/";

    private static Platform instance;

    private Platform() {}

    public static Platform getInstance()
    {
        if (instance==null) {
            instance = new Platform();
        }
        return instance;
    }

    public Boolean isAndroid()
    {
        return isPlatform(PLATFORM_ANDROID);
    }

    public Boolean isIOS()
    {
        return isPlatform(PLATFORM_IOS);
    }

    public Boolean isMw()
    {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }

    protected RemoteWebDriver getDriver () throws Exception
    {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid())
        {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSdDesiredCapabilities());
        }
        else if (this.isMw()) {
            return new ChromeDriver(this.getMwChromeOptions());
        }else {
            throw new Exception("Cannot detect type of the Driver. Platform value " + this.getPlatformVar());
        }
    }

    private DesiredCapabilities getAndroidDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "AndroidTestDevice");
        capabilities.setCapability("appium:platformVersion", "8.0");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");
        capabilities.setCapability("appium:app", "/Users/evgenia/Desktop/JavaAppiumAutomation/MyJavaProject/apks/org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSdDesiredCapabilities()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("appium:deviceName", "iPhone 16");
        capabilities.setCapability("appium:platformVersion", "18.0");
        capabilities.setCapability("appium:automationName", "XCUITest");
        capabilities.setCapability("appium:app", "/Users/evgenia/Desktop/JavaAppiumAutomation/MyJavaProject/apks/Википедия.app");
        return capabilities;
    }

    private ChromeOptions getMwChromeOptions()
    {
        Map<String,Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("heigth", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String,Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D),AppleWebKit/535.19 (KHTML, like Gecko),Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("window-size=340,640");

        return ChromeOptions;
    }

    private boolean isPlatform(String my_platform)
    {
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }
}
