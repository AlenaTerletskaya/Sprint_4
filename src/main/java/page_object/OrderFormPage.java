package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.server.ExportException;

// Создаем класс страницы с формой заказа OrderFormPage
public class OrderFormPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
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

    // Конструктор класса OrderFormCustomerPage
    public OrderFormPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод проверяет, отображается ли заголовок формы заказа
    public void isOrderFormHeaderVisible() {
        driver.findElement(ORDER_FORM_HEADER).isDisplayed();
    }

    // Метод заполняет поле для имени корректными данными
    public void enterValidName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    // Метод заполняет поле для фамилии корректными данными
    public void enterValidSurname(String surname) {
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    // Метод заполняет поле для адреса корректными данными
    public void enterValidAdress(String adress) {
        driver.findElement(ADRESS_FIELD).sendKeys(adress);
    }

    // Метод выбирает станцию метро
    public void chooseMetroStation() {
        driver.findElement(METRO_STATION_FIELD).click();
        driver.findElement(METRO_STATION_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_STATION_FIELD).sendKeys(Keys.ENTER);
    }

    // Метод заполняет поле для номера телефона корректными данными
    public void enterValidPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }

    // Метод кликает по кнопке "Далее"
    public void clickContinueButton() {
        waitElementToBeClicable(CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    // Явное ожидание кликабельности элемента с данным локатором
    public void waitElementToBeClicable(By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLocator)));
    }

}
