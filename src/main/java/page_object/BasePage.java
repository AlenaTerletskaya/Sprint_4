package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// создаем родительский класс с базовыми полями и методами, которые наследуют классы других страниц
public class BasePage {
    // Поля класса
    protected final WebDriver driver; // Поле driver
    // URL главной страницы сайта
    private final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // Конструктор класса BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Статический метод возвращает значение URL главной страницы сайта
    public static String getMainPageUrl() {
        return MAIN_PAGE_URL;
    }

    // Явное ожидание кликабельности элемента с данным локатором
    public void waitElementToBeClicable(By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLocator)));
    }

    // Явное ожидание кликабельности данного элемента
    public void waitElementToBeClicable(WebElement element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Явное ожидание перехода на URL главной страницы
    public void waitUrlToBe () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlToBe(MAIN_PAGE_URL));
    }

    // Явное ожидание отображения элемента с данным локатором
    public void waitElementToBeVisible(By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }


}
