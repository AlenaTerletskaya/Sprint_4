package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.MainPage;

import java.time.Duration;

// Класс тестов для раздела "Вопросы о важном"
@RunWith(Parameterized.class)
public class ImportantQuestionsTests extends BaseTest{

    private final String question; // Поле с вопросом в разделе "Вопросы о важном"
    private boolean actual; // Ожидаемый результат

    // Конструктор с параметрами
    public ImportantQuestionsTests (String questionField) {
        this.question = questionField;
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getQuestion() {
        return new Object[][] {
                {"вопрос о цене и оплате"},
                {"вопрос о нескольких самокатах"},
                {"вопрос о времени аренды"},
                {"вопрос о заказе самоката сегодня"},
                {"вопрос о продлении или возврате"},
                {"вопрос о зарядке самоката"},
                {"вопрос об отмене заказа"},
                {"вопрос о доставке за МКАД"},
        };
    }

    // Запускаем браузер
    @Before
    public void start() {
        setUp();
    }

    // При нажатии на вопрос → открывается соответствующий текст
    @Test
    public void checkClickQuestion_expectTextIsDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Неявное ожидание
        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickQuestion(question); // Кликаем на вопрос

        // Проверяем, открылся ли текст
        actual = mainPage.isAnswerDisplayed(question);
        Assert.assertTrue("Expect: price and payment text is displayed", actual);
    }

    // Закрываем браузер
    @After
    public void finish() {
        cleanUp();
    }
}
