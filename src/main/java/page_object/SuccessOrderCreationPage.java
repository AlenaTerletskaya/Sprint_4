package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создаем класс окна с сообщением об успешном создании заказа
public class SuccessOrderCreationPage extends BasePage {

    // Поля класса
    // Локатор сообщения об успешном создании заказа
    private static final By SUCCESS_ORDER_CREATION_MESSAGE = By.xpath(".//div[text()='Заказ оформлен']");

    // Конструктор класса SuccessOrderCreationPage
    public SuccessOrderCreationPage(WebDriver driver) {
        super(driver);
    }

    // Метод проверяет, отображается ли сообщение об успешном создании заказа
    public boolean isSuccessOrderCreationMessageVisible() {
        return driver.findElement(SUCCESS_ORDER_CREATION_MESSAGE).isDisplayed();
    }
}
