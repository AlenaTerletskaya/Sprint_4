package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Создаем класс окна с вопросом о подтверждении заказа
public class ConfirmQuestionPage extends BasePage {

    // Локатор вопроса о подтверждении заказа
    private static final By CONFIRM_QUESTION = By.xpath(".//div[text()='Хотите оформить заказ?']");
    // Локатор кнопки подтверждения заказа
    private static final By CONFIRM_BUTTON = By.xpath(".//button[text()='Да']");

    // Конструктор класса ConfirmQuestionPage
    public ConfirmQuestionPage(WebDriver driver) {
        super(driver);
    }

    // Метод проверяет, отображается ли вопрос о подтверждении заказа
    public void isConfirmQuestionVisible() {
        driver.findElement(CONFIRM_QUESTION).isDisplayed();
    }

    // Метод кликает по кнопке подтверждения заказа
    public void clickConfirmButton() {
        waitElementToBeClicable(CONFIRM_BUTTON);
        driver.findElement(CONFIRM_BUTTON).click();
    }



}

