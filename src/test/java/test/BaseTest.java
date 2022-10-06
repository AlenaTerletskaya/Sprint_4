package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Базовый тестовый класс, в котором настраивается драйвер. Другие тестовые классы наследуются от базового.
public class BaseTest {
    //Объявляем переменную драйвера
    protected WebDriver driver;

    // Инициализируем драйвер и указываем, какой использовать: ChromeDriver() или FirefoxDriver()
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        // Закрываем сессию драйвера
        driver.quit();
    }
}
