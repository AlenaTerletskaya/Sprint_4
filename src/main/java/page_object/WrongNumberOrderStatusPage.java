package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создаем класс страницы для отсутствующего заказа
public class WrongNumberOrderStatusPage extends BasePage {

    // Локатор изображения для отсутствующего заказа
    private static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY");
    // Локатор поля с введенным номером заказа
    private static final By FIELD_WITH_ORDER_NUMBER = By.xpath(".//input[@placeholder='']");


    // Конструктор класса WrongNumberOrderStatusPage
    public WrongNumberOrderStatusPage(WebDriver driver) {
        super(driver);
    }

    // Геттер возвращает локатор поля с введенным номером заказа
    public By getFieldWithOrderNumberLocator() {
        return FIELD_WITH_ORDER_NUMBER;
    }

    // Метод проверяет, отображается ли изображение для отсутствующего заказа
    public boolean isNotFoundImageVisible() {
        return driver.findElement(NOT_FOUND_IMAGE).isDisplayed();
    }
}
