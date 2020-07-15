package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class Browser {

    static {
        try {
            createAndStartService();
            createDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static WebDriver driver;
    private static ChromeDriverService service;

    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    public static void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }

    public static void quitDriver() {
        driver.quit();
    }


    public static WebDriver getDriver() {
        return driver;
    }

}
