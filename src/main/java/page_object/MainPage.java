package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Создаем класс главной страницы MainPage
public class MainPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    private final static String pageURL = "https://qa-scooter.praktikum-services.ru/"; // URL страницы
    // Локатор вопроса о цене и оплате
    private final static By PRICE_AND_PAYMENT_QUESTION = By.id("accordion__heading-0");
    // Локатор ответа о цене и оплате
    private final static By PRICE_AND_PAYMENT_TEXT = By.id("accordion__panel-0");
    // Локатор элемента "Вопросы о важном"
    private final static By IMPORTANT_QUESTIONS = By.xpath(".//div[text()='Вопросы о важном']");
    // Локатор вопроса о нескольких самокатах
    private final static By MULTIPLE_SCHOOTERS_QUESTION = By.id("accordion__heading-1");
    // Локатор ответа о цене и оплате
    private final static By MULTIPLE_SCHOOTERS_TEXT = By.id("accordion__panel-1");
    // Локатор вопроса о времени аренды
    private static final By RENTAL_TIME_QUESTION = By.id("accordion__heading-2");
    // Локатор ответа о времени аренды
    private final static By RENTAL_TIME_TEXT = By.id("accordion__panel-2");
    // Локатор вопроса о заказе самоката сегодня
    private static final By ORDER_SCHOOTER_TODAY_QUESTION = By.id("accordion__heading-3");
    // Локатор ответа о заказе самоката сегодня
    private final static By ORDER_SCHOOTER_TODAY_TEXT = By.id("accordion__panel-3");
    // Локатор вопроса о продлении или возврате
    private static final By EXTENSION_OR_RETURN_QUESTION = By.id("accordion__heading-4");
    // Локатор ответа о продлении или возврате
    private final static By EXTENSION_OR_RETURN_TEXT = By.id("accordion__panel-4");
    // Локатор вопроса о зарядке самоката
    private static final By SCHOOTER_CHARGING_QUESTION = By.id("accordion__heading-5");
    // Локатор ответа о зарядке самоката
    private final static By SCHOOTER_CHARGING_TEXT = By.id("accordion__panel-5");
    // Локатор вопроса об отмене заказа
    private static final By CANCEL_ORDER_QUESTION = By.id("accordion__heading-6");
    // Локатор ответа об отмене заказа
    private final static By CANCEL_ORDER_TEXT = By.id("accordion__panel-6");
    // Локатор вопроса о доставке за МКАД
    private static final By DELIVERY_OUTSIDE_MOSCOW_QUESTION = By.id("accordion__heading-7");
    // Локатор ответа о доставке за МКАД
    private final static By DELIVERY_OUTSIDE_MOSCOW_TEXT = By.id("accordion__panel-7");
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

    // Метод кликает по вопросу о цене и оплате
    public void clickPriceAndPaymentQuestion() {
        driver.findElement(PRICE_AND_PAYMENT_QUESTION).click();
    }

    // Метод проверяет, отображается ли текст о цене и оплате
    public boolean isPriceAndPaymentTextDisplayed() {
        return driver.findElement(PRICE_AND_PAYMENT_TEXT).isDisplayed();
    }

    // Метод скроллит страницу до вопросов о важном
    public void scrollToImportantQuestions() {
        WebElement ImportantQuestions = driver.findElement(IMPORTANT_QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ImportantQuestions);
    }

    // Метод кликает по вопросу о нескольких самокатах
    public void clickMultipleSchootersQuestion() {
        driver.findElement(MULTIPLE_SCHOOTERS_QUESTION).click();
    }

    // Метод проверяет, отображается ли текст о нескольких самокатах
    public boolean isMultipleSchootersTextDisplayed() {
        return driver.findElement(MULTIPLE_SCHOOTERS_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу о времени аренды
    public void clickRentalTimeQuestion() {
        driver.findElement(RENTAL_TIME_QUESTION).click();
    }

    // Метод проверяет, отображается ли текст о времени аренды
    public boolean isRentalTimeTextDisplayed() {
        return driver.findElement(RENTAL_TIME_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу о заказе самоката сегодня
    public void clickOrderSchooterTodayQuestion() {
        driver.findElement(ORDER_SCHOOTER_TODAY_QUESTION).click();
    }

    // Метод проверяет, отображается ли ответ о заказе самоката сегодня
    public boolean isOrderSchooterTodayTextDisplayed() {
        return driver.findElement(ORDER_SCHOOTER_TODAY_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу о продлении или возврате
    public void clickExtensionOrReturnQuestion() {
        driver.findElement(EXTENSION_OR_RETURN_QUESTION).click();
    }

    // Метод проверяет, отображается ли ответ о продлении или возврате
    public boolean isExtensionOrReturnTextDisplayed() {
        return driver.findElement(EXTENSION_OR_RETURN_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу о зарядке самоката
    public void clickScooterChargingQuestion() {
        driver.findElement(SCHOOTER_CHARGING_QUESTION).click();
    }

    // Метод проверяет, отображается ли ответ о зарядке самоката
    public boolean isScooterChargingTextDisplayed() {
        return driver.findElement(SCHOOTER_CHARGING_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу об отмене заказа
    public void clickCancelOrderQuestion() {
        driver.findElement(CANCEL_ORDER_QUESTION).click();
    }

    // Метод проверяет, отображается ли ответ об отмене заказа
    public boolean isCancelOrderTextDisplayed() {
        return driver.findElement(CANCEL_ORDER_TEXT).isDisplayed();
    }

    // Метод кликает по вопросу о доставке за МКАД
    public void clickDeliveryOutsideMoscowQuestion() {
        driver.findElement(DELIVERY_OUTSIDE_MOSCOW_QUESTION).click();
    }

    // Метод проверяет, отображается ли ответ о доставке за МКАД
    public boolean isDeliveryOutsideMoscowTextDisplayed() {
        return driver.findElement(DELIVERY_OUTSIDE_MOSCOW_TEXT).isDisplayed();
    }

    // Метод кликает по верхней или нижней кнопке заказа самоката
    public void clickOrderButton(String orderButton) {
        if (orderButton.equals("верхняя кнопка заказа")) {
            driver.findElement(UPPER_ORDER_BUTTON).click();
        } else if (orderButton.equals("нижняя кнопка заказа")) {
            WebElement lowerOrderButton = driver.findElement(LOWER_ORDER_BUTTON);
            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", lowerOrderButton);
            lowerOrderButton.click();
        }
    }

}

