package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.*;

@RunWith(Parameterized.class)
// Класс для тестирования заказа самоката
public class OrderScooterTest extends BaseTest {

    // Поля класса
    private final String orderButton; // Kнопка заказа (верхняя или нижняя)
    private final String name; // Имя заказчика
    private final String surname; // Фамилия заказчика
    private final String adress; // Адрес доставки
    private final String phoneNumber; // Номер телефона
    private final String rentalPeriod; // Период аренды из выпадающего меню
    private final String colour; // Цвет самоката
    private final String comment; // Комментарий
    private boolean actual; // Ожидаемый результат

    // Конструктор с параметрами
    public OrderScooterTest(String orderButton, String name, String surname, String adress, String phoneNumber,
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
                    {"верхняя кнопка заказа", "Гайнельмухаммет",
                            "ЧеловекСОченьДлиннойФамилиейЧеловекСОченьДлиннойФамилиейЧеловекСОченьДлиннойФамилией",
                            "РФ, г. Новосибирск, ул. Дема, адрес в 49 символов",
                            "+791347295468", "семеро суток", "grey",
                            "Длинный комментарий для курьера. Длинный комментарий для курьера. " +
                                    "Длинный комментарий для курьера. Длинный комментарий для курьера." +
                                    "Длинный комментарий для курьера. Длинный комментарий для курьера."
                    },


            };
    }

    // Тест: проверяем весь флоу позитивного сценария заказа самоката
    @Test
    public void checkOrderScooterValidData_expectSchooterIsOrdered() {
        super.implicitlyWait(3); // Неявное ожидание

        // Создаем экземпляр класса главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickOrderButton(orderButton); // Кликаем по кнопке заказа самоката (верхней или нижней)

        // Создаем экземпляр класса страницы формы заказа
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.isOrderFormHeaderVisible(); // Проверяем, отображается ли заголовок формы заказа
        orderFormPage.enterData(orderFormPage.getNameLocator(), name); // Вводим корректное имя
        orderFormPage.enterData(orderFormPage.getSurnameLocator(), surname); // Вводим корректную фамилию
        orderFormPage.enterData(orderFormPage.getAdressLocator(), adress); // Вводим корректный адрес
        orderFormPage. chooseMetroStation(); // Выбираем станцию метро
        orderFormPage.enterData(orderFormPage.getPhoneNumberLocator(), phoneNumber); // Вводим корректный номер телефона
        orderFormPage.clickContinueButton(); // Кликаем на кнопку продолжения

        // Создаем экземпляр класса страницы про аренду
        RentPage rentPage = new RentPage(driver);
        rentPage.isRentHeaderVisible(); // Проверяем, отображается ли заголовок про аренду
        rentPage.enterValidDeliveryDate(); // Вводим корректную дату доставки
        rentPage.chooseRentalPeriod(rentalPeriod); // Выбираем срок ареды
        rentPage.chooseColour(colour); // Выбираем цвет самоката
        orderFormPage.enterData(rentPage.getCommentLocator(), comment); // Вводим комментарий
        rentPage.clickOrderButton(); // Кликаем по кнопке подтверждения заказа

        // Создаем экземпляр класса окна с вопросом о подтверждении заказа
        ConfirmQuestionPage confirmQuestionPage = new ConfirmQuestionPage(driver);
        confirmQuestionPage.isConfirmQuestionVisible(); // Проверяем, отображается ли вопрос о подтверждении заказа
        confirmQuestionPage.clickConfirmButton(); // Кликаем на кнопку подтверждения заказа

        // Создаем экземпляр класса окна с сообщением об успешном создании заказа
        SuccessOrderCreationPage successOrderCreationPage = new SuccessOrderCreationPage(driver);
        // Проверяем, отображается ли сообщение об успешном создании заказа:
        actual = successOrderCreationPage.isSuccessOrderCreationMessageVisible();
        Assert.assertTrue("Expected: a message is displayed that the order was created successfully ",
                actual);
    }

}
