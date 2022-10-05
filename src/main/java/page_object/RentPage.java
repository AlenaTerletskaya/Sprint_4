package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Создаем класс страницы про аренду RentPage
public class RentPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    // Локатор заголовка страницы про аренду
    private static final By RENT_HEADER = By.cssSelector("div.Order_Header__BZXOb");
    // Локатор поля выбора даты доставки
    private static final By DELIVERY_DATE_FIELD = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Локатор поля выбора срока аренды
    private static final By RENTAL_PERIOD_FIELD = By.cssSelector("div.Dropdown-root");
    // Локатор пункта выпадающего меню о сроке аренды
    private By rentalPeriodDropdownOption;
    // Локатор чек-бокса c цветом самоката
    private By colourCheckBox;
    // Локатор поля для комментария
    private static final By COMMENT_FIELD = By.cssSelector("input[placeholder='Комментарий для курьера']");
    // Локатор кнопки подтверждения заказа
    private static final By ORDER_CONFIRM_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Конструктор класса RentPage
    public RentPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод проверяет, отображается ли заголовок про аренду
    public void isRentHeaderVisible() {
        driver.findElement(RENT_HEADER).isDisplayed();
    }

    // Метод вводит корректную дату доставки
    public void enterValidDeliveryDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // Готовим формат даты "дд.мм.гггг"
        // Получаем текущую дату, прибавляем к ней 1 день и форматируем
        String date = LocalDate.now().plusDays(1).format(formatter);
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(date); // Вводим дату в поле с датой доставки
        driver.findElement(DELIVERY_DATE_FIELD).sendKeys(Keys.ENTER); // Нажимаем Enter
    }

    // Метод выбирает срок аренды из выпадающего меню
    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_FIELD).click(); // Кликаем на поле выбора срока аренды
        // Выбираем срок аренды из выпадающего списка и кликаем на него
        this.rentalPeriodDropdownOption = By.xpath(".//div[text()='" + rentalPeriod + "']");
        driver.findElement(rentalPeriodDropdownOption).click();
    }

    // Метод выбирает цвет самоката
    public void chooseColour(String colour) {
        this.colourCheckBox = By.id(colour);
        driver.findElement(colourCheckBox).click();
    }

    // Метод вводит комментарий
    public void enterComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    // Метод кликает по кнопке подтверждения заказа
    public void clickOrderButton() {
        waitElementToBeClicable(ORDER_CONFIRM_BUTTON);
        driver.findElement(ORDER_CONFIRM_BUTTON).click(); // Кликаем по кнопке подтверждения заказа
    }

    // Явное ожидание кликабельности элемента с данным локатором
    public void waitElementToBeClicable(By elementLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(elementLocator)));
    }
}
