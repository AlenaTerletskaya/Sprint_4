package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создаем класс страницы с логотипом самоката
public class LogoPage extends BasePage {
    // Поля класса
    private static final By LOGO_SCOOTER = By.cssSelector("a.Header_LogoScooter__3lsAR"); // Локатор логотипа самоката
    private static final By LOGO_YANDEX = By.cssSelector("a.Header_LogoYandex__3TSOI"); // Локатор логотипа Яндекса


    // Конструктор класса LogoScooterPage
    public LogoPage(WebDriver driver) {
        super(driver);
    }

    // Метод открывает в браузере страницу с заданным url
    public void open(String url) {
        driver.get(url);
    }

    // Метод кликает по логотипу
    public void clickLogo(By LogoLocator) {
        driver.findElement(LogoLocator).click();
    }

    // Геттер возвращает локатор логотипа самоката
    public By getLogoScooter() {
        return LOGO_SCOOTER;
    }

    // Кликаем на логотип Яндекса и переходим в новое окно
    public void clickYandexLogoAndSwitchToWindow() {
        clickLogo(LOGO_YANDEX);
        String handle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(handle);
    }
}
