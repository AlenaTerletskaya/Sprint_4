package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page_object.MainPage;

import java.time.Duration;

// Класс тестов для раздела "Вопросы о важном"
public class ImportantQuestionsTests extends BaseTest{

    // Запускаем браузер
    @Before
    public void start() {
        setUp();
    }

    // При нажатии на вопрос о цене и оплате → открывается соответствующий текст
    @Test
    public void checkClickPriceAndPaymentQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickPriceAndPaymentQuestion(); // Кликаем на вопрос о цене и оплате
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: price and payment text is displayed",
                mainPage.isPriceAndPaymentTextDisplayed());
    }

    // При нажатии на вопрос о нескольких самокатах → открывается соответствующий текст
    @Test
    public void checkClickMultipleSchootersQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickMultipleSchootersQuestion(); // Кликаем на вопрос о нескольких самокатах
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isMultipleSchootersTextDisplayed());
    }

    // При нажатии на вопрос о времени аренды → открывается соответствующий текст
    @Test
    public void checkClickRentalTimeQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickRentalTimeQuestion(); // Кликаем на вопрос о времени аренды
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isRentalTimeTextDisplayed());
    }

    // При нажатии на вопрос о заказе самоката сегодня → открывается соответствующий текст
    @Test
    public void checkClickOrderSchooterTodayQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickOrderSchooterTodayQuestion(); // Кликаем на вопрос о заказе самоката сегодня
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isOrderSchooterTodayTextDisplayed());
    }

    // При нажатии на вопрос о продлении или возврате → открывается соответствующий текст
    @Test
    public void checkClickExtensionOrReturnQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickExtensionOrReturnQuestion(); // Кликаем на вопрос о продлении или возврате
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isExtensionOrReturnTextDisplayed());
    }

    // При нажатии на вопрос о зарядке самоката → открывается соответствующий текст
    @Test
    public void checkClickScooterChargingQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickScooterChargingQuestion(); // Кликаем на вопрос о зарядке самоката
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isScooterChargingTextDisplayed());
    }

    // При нажатии на вопрос об отмене заказа → открывается соответствующий текст
    @Test
    public void checkClickCancelOrderQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickCancelOrderQuestion(); // Кликаем на вопрос об отмене заказа
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isCancelOrderTextDisplayed());
    }

    // При нажатии на вопрос о доставке за МКАД → открывается соответствующий текст
    @Test
    public void checkClickDeliveryOutsideMoscowQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.scrollToImportantQuestions(); // Скроллим страницу до вопросов о важном
        mainPage.clickDeliveryOutsideMoscowQuestion(); // Кликаем на вопрос о доставке за МКАД
        // Проверяем, открылся ли текст
        Assert.assertTrue("Expect: multiple schooters text is displayed",
                mainPage.isDeliveryOutsideMoscowTextDisplayed());
    }

    // Закрываем браузер
    @After
    public void finish() {
        cleanUp();
    }
}
