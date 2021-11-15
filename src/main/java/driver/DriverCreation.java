package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyReader;

public class DriverCreation {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        if (driver.get() == null) {
            createDriver();
        }
    }

    public static void createDriver() {
        PropertyReader.getProperties().containsKey("chrome.driver.options");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(PropertyReader.getProperties().getProperty("chrome.driver.options").split(";"));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        driver.set(webDriver);

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}