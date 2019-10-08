package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Sistema : TODO
 * Funcionalidad :TODO
 * Descripcion : La clase Appium permite.. TODO
 *
 * @author Marco
 * @since 03-10-2019
 */
public class Appium {

    private  AndroidDriver<AndroidElement> appiumDriver;

    public AndroidDriver<AndroidElement> getAppiumDriver() {
        return appiumDriver;
    }

    public void setAppiumDriver(AndroidDriver<AndroidElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void initAppium() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("device", "Samsung Galaxy S8");
//        caps.setCapability("os_version", "7.0");
        //caps.setCapability("deviceName","Motorola_Moto_G6_free");
        caps.setCapability("deviceName","phone");
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","Uiautomator2");
        //caps.setCapability("phoneOnly",true);
        caps.setCapability("appPackage","cl.akzio.alix");
        caps.setCapability("appActivity",".SplashActivity");
        //is only for browserstack
//        caps.setCapability("app","bs://asd");
        //only for saucelabs

        //caps.setCapability("testobject_api_key","asd");

//        this.setAppiumDriver(new AndroidDriver<AndroidElement>(new URL("http://asd:asd@hub-cloud.browserstack.com/wd/hub"),caps));
        this.setAppiumDriver(new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),caps));
        }
    }


