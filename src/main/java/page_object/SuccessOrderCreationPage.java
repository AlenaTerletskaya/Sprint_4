package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создаем класс окна с сообщением об успешном создании заказа
public class SuccessOrderCreationPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    // Локатор сообщения об успешном создании заказа
    private static final By SUCCESS_ORDER_CREATION_MESSAGE = By.xpath(".//div[text()='Заказ оформлен']");

    // Конструктор класса SuccessOrderCreationPage
    public SuccessOrderCreationPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод проверяет, отображается ли сообщение об успешном создании заказа
    public boolean isSuccessOrderCreationMessageVisible() {
        return driver.findElement(SUCCESS_ORDER_CREATION_MESSAGE).isDisplayed();
    }
}
