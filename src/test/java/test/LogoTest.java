package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.BasePage;
import page_object.LogoPage;

@RunWith(Parameterized.class)
// Класс для тестирования логотипа самоката
public class LogoTest extends BaseTest {
    // Поля класса
    private final String url; // url страницы сайта

    // Конструктор с параметрами
    public LogoTest(String url) {
        this.url = url;
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getUrlData() {
        return new Object[][] {
                {BasePage.getMainPageUrl()}, // URL главной страницы
                {"https:///qa-scooter.praktikum-services.ru/order"}, // URL станицы оформления заказа
                // URL станицы результата проверки заказа по номеру 0.
                {"https://qa-scooter.praktikum-services.ru/track?t=0"},
        };
    }

    // Если нажать на логотип самоката, попадёшь на главную страницу «Самоката».
    @Test
    public void checkClickLogoScooter_expectGoToMainPage() {
        super.implicitlyWait(3); // Неявное ожидание

        // Создаем экземпляр класса верхней части станицы c логотипом
        LogoPage logoPage = new LogoPage(driver);
        logoPage.open(url); // Открываем страницу в браузере
        logoPage.clickLogo(logoPage.getLogoScooter()); // Кликаем по логотипу самоката

        // Проверяем, что перешли на главную страницу сайта
        Assert.assertEquals("Expected: current page URL should be egual main page URL",
                BasePage.getMainPageUrl(), driver.getCurrentUrl());
    }

    // Если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса
    @Test
    public void checkClickLogoYandex_expectGoToYandexMainPage() {
        super.implicitlyWait(3); // Неявное ожидание

        // Создаем экземпляр класса верхней части станицы c логотипом
        LogoPage logoPage = new LogoPage (driver);
        logoPage.open(url); // Открываем страницу в браузере
        logoPage.clickYandexLogoAndSwitchToWindow(); // Кликаем на логотип Яндекса и переходим в новое окно

        // Проверяем, что URL в новом окне совпадает с URL на главной странице Яндекса
        String expected = "https://dzen.ru/?yredirect=true"; // Ожидаемый URL
        String actual = driver.getCurrentUrl(); // Фактический URL
        Assert.assertEquals("Expected: current page URL should be egual " + actual, expected, actual);
    }


}
