package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Базовый тестовый класс, в котором настраивается драйвер. Другие тестовые классы наследуются от базового.
public class BaseTest {
    //Объявляем переменную драйвера
    protected WebDriver driver;

    // Инициализируем драйвер и указываем, какой использовать: ChromeDriver() или FirefoxDriver()
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Distributions\\Webdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public void cleanUp() {
        // Закрываем сессию драйвера
        driver.quit();
    }
}
