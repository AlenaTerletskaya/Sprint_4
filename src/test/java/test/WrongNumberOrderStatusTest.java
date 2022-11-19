package test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import page_object.MainPage;
import page_object.WrongNumberOrderStatusPage;

// Класс для тестирования страницы статуса заказа.
@RunWith(JUnitParamsRunner.class)
public class WrongNumberOrderStatusTest extends BaseTest {

    // При вводе неправильного номера заказа должно быть написано, что такого заказа нет.
    @Test
    @Parameters({"0"})
    public void checkEnterWrongOrderNumber_expectNoOrderOnStatusPage(String wrongOrderNumber) {

        // Создаем экземпляр класса главной страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickStatusOrderButton(); // Кликаем по кнопке проверки статуса заказа
        mainPage.waitElementToBeVisible(mainPage.getOrderNumberFieldLocator());
        mainPage.enterWrongOrderNumber(wrongOrderNumber); // Вводим неверный номер заказа
        mainPage.clickGoButton(); // Кликаем на кнопку "Go!"

        // Создаем экземпляр страницы статуса заказа с неправильным номером
        WrongNumberOrderStatusPage wrongNumberOrderStatusPage = new WrongNumberOrderStatusPage(driver);
        // Проверяем, отображается ли изображение для отсутствующего заказа
        boolean actual = wrongNumberOrderStatusPage.isNotFoundImageVisible();
        Assert.assertTrue("Expected: not found image should be visible", actual);
    }

}
