package test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import page_object.MainPage;
import page_object.OrderFormPage;

// Класс для тестирования ошибок при заполнении полей формы заказа
@RunWith(JUnitParamsRunner.class)
public class OrderFormFieldsErrorTest extends BaseTest {

    @Before
    public void openOrderForm() {
        super.implicitlyWait(3);
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickOrderButton("верхняя кнопка заказа"); // Кликаем по верхней кнопке заказа самоката
    }

    // Метод проверяет ошибки при вводе невалидного имени
    @Test
    @Parameters({"", "ф", "Гайнельмухаммета", "asd", "123", "Анна-Мария", "Анна-Мария", "Д'Артаньян"})
    public void enterInvalidName_expectError(String name) {
        OrderFormPage orderFormPage = new OrderFormPage(driver); // Создаем экземпляр класса страницы формы заказа
        orderFormPage.enterData(orderFormPage.getNameLocator(), name); // Вводим невалидное имя
        orderFormPage.clickContinueButton(); // Кликаем по кнопке "Далее"
        // Проверяем, отобразился ли текст ошибки
        Boolean actual = orderFormPage.isErrorVisible(orderFormPage.getNameErrorLocator());
        Assert.assertTrue("Error shoul be visible: \"Введите корректное имя\"", actual);
    }

    // Метод проверяет ошибки при вводе невалидной фамилии
    @Test
    @Parameters({"", "ф", "asd", "123", "Пушкин-Лермонтов", "Пушкин_Лермонтов", "Д'Артаньян"})
    public void enterInvalidSurname_expectError(String surname) {
        OrderFormPage orderFormPage = new OrderFormPage(driver); // Создаем экземпляр класса страницы формы заказа
        orderFormPage.enterData(orderFormPage.getSurnameLocator(), surname);  // Вводим невалидную фамилию
        orderFormPage.clickContinueButton(); // Кликаем по кнопке "Далее"
        // Проверяем, отобразился ли текст ошибки
        Boolean actual = orderFormPage.isErrorVisible(orderFormPage.getSurnameErrorLocator());
        Assert.assertTrue("Error shoul be visible: \"Введите корректную фамилию\"", actual);
    }

    // Метод проверяет ошибки при вводе невалидного адреса
    @Test
    @Parameters({"", "адре", "adress", "РФ\\, г. Новосибирск\\, ул. Демак\\, адрес в 50 символов", "адрес_!?:;@"})
    public void enterInvalidAdress_expectError(String adress) {
        OrderFormPage orderFormPage = new OrderFormPage(driver); // Создаем экземпляр класса страницы формы заказа
        orderFormPage.enterData(orderFormPage.getAdressLocator(), adress);  // Вводим невалидный адрес
        orderFormPage.clickContinueButton(); // Кликаем по кнопке "Далее"
        // Проверяем, отобразился ли текст ошибки
        Boolean actual = orderFormPage.isErrorVisible(orderFormPage.getAdressErrorLocator());
        Assert.assertTrue("Error shoul be visible: \"Введите корректный адрес\"", actual);
    }

    // Метод проверяет ошибки при вводе невалидного номера телефона
    @Test
    @Parameters({"", "1234567890", "12345678901234", "ф12345678901", "-12345678901", "s12345678901"})
    public void enterInvalidPhoneNumber_expectError(String phoneNumber) {
        OrderFormPage orderFormPage = new OrderFormPage(driver); // Создаем экземпляр класса страницы формы заказа
        orderFormPage.enterData(orderFormPage.getPhoneNumberLocator(), phoneNumber);  // Вводим невалидный номер телефона
        orderFormPage.clickContinueButton(); // Кликаем по кнопке "Далее"
        // Проверяем, отобразился ли текст ошибки
        Boolean actual = orderFormPage.isErrorVisible(orderFormPage.getPhoneNumberErrorLocator());
        Assert.assertTrue("Error shoul be visible: \"Введите корректный номер\"", actual);
    }

    // Метод проверяет ошибки при невыбранной станции метро
    @Test
    public void enterInvalidMetroStation_expectError() {
        OrderFormPage orderFormPage = new OrderFormPage(driver); // Создаем экземпляр класса страницы формы заказа
        orderFormPage.clickContinueButton(); // Кликаем по кнопке "Далее"
        // Проверяем, отобразился ли текст ошибки
        Boolean actual = orderFormPage.isErrorVisible(orderFormPage.getMetroStationErrorLocator());
        Assert.assertTrue("Error shoul be visible: \"Выберите станцию\"", actual);
    }





}
