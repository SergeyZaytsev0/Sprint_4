package scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverSettings {
    public static ChromeDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
           options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);// драйвер для браузера Chrome
        driver.get("https://qa-scooter.praktikum-services.ru/");// переход на страницу тестового приложения
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
