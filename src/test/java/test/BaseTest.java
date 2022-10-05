package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Базовый тестовый класс, в котором настраивается драйвер. Другие тестовые классы наследуются от базового.
public class BaseTest {
    //Объявляем переменную драйвера
    protected WebDriver driver;

    // Инициализируем драйвер и указываем, какой использовать: ChromeDriver() или FirefoxDriver()
    public void setUp() {
        driver = new ChromeDriver();
    }

    public void cleanUp() {
        // Закрываем сессию драйвера
        driver.quit();
    }
}
