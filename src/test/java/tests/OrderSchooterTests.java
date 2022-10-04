package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.*;

import java.time.Duration;


@RunWith(Parameterized.class)
// Класс для тестирования заказа самоката
public class OrderSchooterTests extends BaseTest {

    // Поля класса
    private final String orderButton; // Kнопка заказа (верхняя или нижняя)
    private final String name; // Имя заказчика
    private final String surname; // Фамилия заказчика
    private final String adress; // Адрес доставки
    private final String phoneNumber; // Номер телефона
    private final String rentalPeriod; // Период аренды из выпадающего меню
    private final String colour; // Цвет самоката
    private final String comment; // Комментарий
    private boolean actualResult; // Ожидаемый результат

    // Конструктор с параметрами
    public OrderSchooterTests(String orderButton, String name, String surname, String adress, String phoneNumber,
                              String rentalPeriod, String colour, String comment)
    {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getOrderFormData() {
            return new Object[][] {
                    // Короткие данные
                    {"верхняя кнопка заказа", "Ян", "Ши", "Бийск", "83823315149", "сутки", "black", "1"},
                    // Длинные данные
                    {"нижняя кнопка заказа", "Гайнельмухаммет",
                            "ЧеловекСОченьДлиннойФамилиейЧеловекСОченьДлиннойФамилиейЧеловекСОченьДлиннойФамилией",
                            "РФ, г. Новосибирск, ул. Демакова, д. 12а, кв. 456",
                            "+791347295468", "семеро суток", "grey",
                            "Длинный комментарий для курьера. Длинный комментарий для курьера. " +
                                    "Длинный комментарий для курьера. Длинный комментарий для курьера." +
                                    "Длинный комментарий для курьера. Длинный комментарий для курьера."
                    },
            };
    }

    // Запускаем браузер
    @Before
    public void start() {
        setUp();
    }

    // Тест: проверяем весь флоу позитивного сценария заказа самоката
    @Test
    public void checkOrderSchooterValidData_expectSchooterIsOrdered() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Неявное ожидание
        // Создаем экземпляр класса главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickOrderButton(orderButton); // Кликаем по кнопке заказа самоката (верхней или нижней)
        // Создаем экземпляр класса страницы формы заказа
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.isOrderFormHeaderVisible(); // Проверяем, отображается ли заголовок формы заказа
        orderFormPage.enterValidName(name); // Вводим корректное имя
        orderFormPage.enterValidSurname(surname); // Вводим корректную фамилию
        orderFormPage.enterValidAdress(adress); // Вводим корректный адрес
        orderFormPage.chooseMetroStation(); // Выбираем станцию метро
        orderFormPage.enterValidPhoneNumber(phoneNumber); // Вводим корректный номер телефона
        orderFormPage.clickContinueButton(); // Кликаем на кнопку продолжения
        // Создаем экземпляр класса страницы про аренду
        RentPage rentPage = new RentPage(driver);
        rentPage.isRentHeaderVisible(); // Проверяем, отображается ли заголовок про аренду
        rentPage.enterValidDeliveryDate(); // Вводим корректную дату доставки
        rentPage.chooseRentalPeriod(rentalPeriod); // Выбираем срок ареды
        rentPage.chooseColour(colour); // Выбираем цвет самоката
        rentPage.enterComment(comment); // Вводим комментарий
        rentPage.clickOrderButton(); // Кликаем по кнопке подтверждения заказа
        // Создаем экземпляр класса окна с вопросом о подтверждении заказа
        ConfirmQuestionPage confirmQuestionPage = new ConfirmQuestionPage(driver);
        confirmQuestionPage.isConfirmQuestionVisible(); // Проверяем, отображается ли вопрос о подтверждении заказа
        // Проверяем активность кнопки подтверждения заказа
        System.out.println(confirmQuestionPage.isConfirmButtonEnable());
        Assert.assertTrue("Expected: order confirmation button is active",
                confirmQuestionPage.isConfirmButtonEnable());
        confirmQuestionPage.clickConfirmButton(); // Кликаем на кнопку подтверждения заказа
        // Создаем экземпляр класса окна с сообщением об успешном создании заказа
        SuccessOrderCreationPage successOrderCreationPage = new SuccessOrderCreationPage(driver);

        // Проверяем, отображается ли сообщение об успешном создании заказа:
        // Сохраняем фактический результат в переменную
        actualResult = successOrderCreationPage.isSuccessOrderCreationMessageVisible();
        // Проверяем, соответствует ли фактический результат ожидаемому
        Assert.assertTrue("Expected: a message is displayed that the order was created successfully ",
                actualResult);
    }

     // Закрываем браузер
    @After
    public void finish() {
        cleanUp();
    }

}
