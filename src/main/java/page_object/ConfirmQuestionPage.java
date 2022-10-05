package page_object;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Создаем класс окна с вопросом о подтверждении заказа
public class ConfirmQuestionPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    // Локатор вопроса о подтверждении заказа
    private static final By CONFIRM_QUESTION = By.cssSelector("div.Order_ModalHeader__3FDaJ");
    // Локатор кнопки подтверждения заказа
//    private static final By CONFIRM_BUTTON = By.xpath(".//button[text()='Да']");
    private static final By CONFIRM_BUTTON = By.xpath(".//div[contains(@class,'Order_Modal__YZ-d3')]//div[contains(@class,'Order_Buttons__1xGrp')]//button[not(contains(@class, 'Button_Inverted__3IF-i'))]");
    private static final By REJECT_BUTTON = By.xpath(".//button[text()='Нет']");

    // Конструктор класса ConfirmQuestionPage
    public ConfirmQuestionPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод проверяет, отображается ли вопрос о подтверждении заказа
    public void isConfirmQuestionVisible() {
        driver.findElement(CONFIRM_QUESTION).isDisplayed();
    }

   // Метод проверяет, активна ли кнопка подтверждения заказа
    public boolean isConfirmButtonEnable() {
        return driver.findElement(CONFIRM_BUTTON).isEnabled();
    }

    // Метод кликает по кнопке подтверждения заказа
    public void clickConfirmButton() {
        waitElementToBeClicable(CONFIRM_BUTTON);
        driver.findElement(CONFIRM_BUTTON).click();
    }

    // Явное ожидание кликабельности элемента с данным локатором
    public void waitElementToBeClicable(By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLocator)));
    }

}

