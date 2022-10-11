package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// Создаем класс страницы с формой заказа OrderFormPage
public class OrderFormPage extends BasePage{

    // Поля класса
    // Локатор заголовка формы заказа
    private static final By ORDER_FORM_HEADER = By.cssSelector("div.Order_Header__BZXOb");
    // Локатор поля ввода имени
    private static final By NAME_FIELD = By.cssSelector("input[placeholder='* Имя']");
    // Локатор поля ввода фамилии
    private static final By SURNAME_FIELD = By.cssSelector("input[placeholder='* Фамилия']");
    // Локатор поля ввода адреса
    private static final By ADRESS_FIELD = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Локатор поля выбора станции метро
    private static final By METRO_STATION_FIELD = By.cssSelector("input[placeholder='* Станция метро']");
    // Локатор поля ввода номера телефона
    private static final By PHONE_NUMBER_FIELD =
            By.cssSelector(("input[placeholder='* Телефон: на него позвонит курьер']"));
    // Локатор кнопки "Далее"
    private static final By CONTINUE_BUTTON = By.xpath(".//button[text()='Далее']");
    // Локатор ошибки под полем ввода имени
    private static final By NAME_FIELD_ERROR = By.xpath(".//div[text()='Введите корректное имя']");
    // Локатор ошибки под полем ввода фамилии
    private static final By SURNAME_FIELD_ERROR = By.xpath(".//div[text()='Введите корректную фамилию']");
    // Локатор ошибки под полем ввода адреса
    private static final By ADRESS_FIELD_ERROR = By.xpath(".//div[text()='Введите корректный адрес']");
    // Локатор ошибки под полем ввода номера телефона
    private static final By PHONE_NUMBER_FIELD_ERROR = By.xpath(".//div[text()='Введите корректный номер']");
    // Локатор ошибки под полем выбора станции метро
    private static final By METRO_STATION_FIELD_ERROR = By.xpath(".//div[text()='Выберите станцию']");


    // Конструктор класса OrderFormCustomerPage
    public OrderFormPage(WebDriver driver) {
        super(driver);
    }

    // Геттер возвращает локатор ошибки под полем ввода имени
    public By getNameErrorLocator() {
        return NAME_FIELD_ERROR;
    }

    // Геттер возвращает локатор поля ввода имени
    public By getNameLocator() {
        return NAME_FIELD;
    }

    // Геттер возвращает локатор поля ввода фамилии
    public By getSurnameLocator() {
        return SURNAME_FIELD;
    }

    // Геттер возвращает локатор ошибки под полем ввода фамилии
    public By getSurnameErrorLocator() {
        return SURNAME_FIELD_ERROR;
    }

    // Геттер возвращает локатор поля ввода адреса
    public By getAdressLocator() {
        return ADRESS_FIELD;
    }

    // Геттер возвращает локатор ошибки под полем ввода адреса
    public By getAdressErrorLocator() {
        return ADRESS_FIELD_ERROR;
    }

    // Геттер возвращает локатор поля ввода номера телефона
    public By getPhoneNumberLocator() {
        return PHONE_NUMBER_FIELD;
    }

    // Геттер возвращает локатор ошибки под полем ввода номера телефона
    public By getPhoneNumberErrorLocator() {
        return PHONE_NUMBER_FIELD_ERROR;
    }

    // Геттер возвращает локатор ошибки под полем выбора станции метро
    public By getMetroStationErrorLocator() {
        return METRO_STATION_FIELD_ERROR;
    }



    // Метод проверяет, отображается ли заголовок формы заказа
    public void isOrderFormHeaderVisible() {
        driver.findElement(ORDER_FORM_HEADER).isDisplayed();
    }

    // Метод заполняет поле c определенным локатором данными
    public void enterData(By locator, String data) {
        driver.findElement(locator).sendKeys(data);
    }

    // Метод выбирает станцию метро
    public void chooseMetroStation() {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(METRO_STATION_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_STATION_FIELD).sendKeys(Keys.ENTER);
    }

    // Метод кликает по кнопке "Далее"
    public void clickContinueButton() {
        waitElementToBeClicable(CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    // Метод проверяет отборажение ошибки под полем ввода имени
    public boolean isErrorVisible(By errorLocator) {
        // waitElementToBeVisible(errorLocator);
        return driver.findElement(errorLocator).isDisplayed();
    }


}
