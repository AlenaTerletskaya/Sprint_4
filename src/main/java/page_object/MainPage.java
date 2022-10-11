package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Создаем класс главной страницы MainPage
public class MainPage extends BasePage {

    // Поля класса
    // Локатор верхней кнопки заказа самоката
    private static final By UPPER_ORDER_BUTTON =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Локатор нижней кнопки заказа самоката
    private static final By LOWER_ORDER_BUTTON =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // Локатор кнопки проверки статуса заказа
    private static final By STATUS_ORDER_BUTTON = By.cssSelector("button.Header_Link__1TAG7");
    // Локатор поля для ввода номера заказа
    private static final By ORDER_NUMBER_FIELD = By.xpath(".//input[@placeholder='Введите номер заказа']");
    // Локатор кнопки "Go!"
    private static final By GO_BUTTON = By.xpath(".//button[text()='Go!']");


    // Конструктор класса MainPage
    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Геттер возвращает локатор поля для ввода номера заказа
    public By getOrderNumberFieldLocator() {
        return ORDER_NUMBER_FIELD;
    }




    // Метод открывает главную страницу в браузере
    public void open() {
        driver.get(BasePage.getMainPageUrl());
    }

    // Метод кликает на вопрос
    public void clickQuestion(String questionNumber) {
        // Определяем локатор вопроса
        By questionLocator;
        String questionId = String.format("accordion__heading-%s", questionNumber);
        questionLocator = By.id(questionId);
        // Находим вопрос по локатору
        WebElement guestionElement = driver.findElement(questionLocator);
        // Скроллим страницу до вопроса
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", guestionElement);
        // Ожидаем, что вопрос станет кликабельным;
        waitElementToBeClicable(guestionElement);
        // Кликаем на вопрос
        guestionElement.click();
    }

    // Метод проверяет, отображается ли ответ на вопрос
    public boolean isAnswerDisplayed(String questionNumber) {
        // Определяем локатор ответа
        By answerLocator;
        String answerId = String.format("accordion__panel-%s", questionNumber);
        answerLocator = By.id(answerId);
        // Находим ответ по локатору
        WebElement answerElement = driver.findElement(answerLocator);
        // Ожидаем, что ответ станет кликабельным;
        waitElementToBeClicable(answerElement);
        return answerElement.isDisplayed();
    }

    // Метод кликает по верхней или нижней кнопке заказа самоката
    public void clickOrderButton(String orderButton) {
        if (orderButton.equals("верхняя кнопка заказа")) {
            driver.findElement(UPPER_ORDER_BUTTON).click();
        } else if (orderButton.equals("нижняя кнопка заказа")) {
            // Скроллим до кнопки
            WebElement lowerOrderButton = driver.findElement(LOWER_ORDER_BUTTON);
            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", lowerOrderButton);
            waitElementToBeClicable(lowerOrderButton); // Явное ожидание кликабельности кнопки
            lowerOrderButton.click();
        }
    }

    // Метод кликает по кнопке проверки статуса заказа
    public void clickStatusOrderButton() {
        driver.findElement(STATUS_ORDER_BUTTON).click();
    }

    // Метод вводит неправильный номер заказа
    public void enterWrongOrderNumber(String wrongOrderNumber) {
        driver.findElement(ORDER_NUMBER_FIELD).sendKeys(wrongOrderNumber);
    }

    // Метод кликает по кнопке "Go!"
    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }
}

