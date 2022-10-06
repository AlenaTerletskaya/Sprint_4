package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Создаем класс главной страницы MainPage
public class MainPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    private final static String pageURL = "https://qa-scooter.praktikum-services.ru/"; // URL страницы
    // Локатор верхней кнопки заказа самоката
    private static final By UPPER_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Локатор нижней кнопки заказа самоката
    private static final By LOWER_ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // Конструктор класса MainPage
    public MainPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод открывает страницу в браузере
    public void open() {
        driver.get(pageURL);
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

    // Явное ожидание кликабельности элемента
    public void waitElementToBeClicable(WebElement element) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}

