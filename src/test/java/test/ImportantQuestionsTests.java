package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page_object.MainPage;

import java.time.Duration;

// Класс тестов для раздела "Вопросы о важном"
@RunWith(Parameterized.class)
public class ImportantQuestionsTests extends BaseTest{

    private final String questionNumber; // Поле с номером вопроса в разделе "Вопросы о важном"
    private boolean actual; // Ожидаемый результат

    // Конструктор с параметрами
    public ImportantQuestionsTests (String questionField) {
        this.questionNumber = questionField;
    }

    // Метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getQuestionNumber() {
        return new Object[][] {
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"},
        };
    }

    // При нажатии на вопрос → открывается соответствующий текст
    @Test
    public void checkClickQuestion_expectTextIsDisplayed() {
        super.implicitlyWait(5); // Неявное ожидание

        MainPage mainPage = new MainPage(driver); // Создаем экземпляр класса главной страницы
        mainPage.open(); // Открываем страницу в браузере
        mainPage.clickQuestion(questionNumber); // Кликаем на вопрос

        // Проверяем, открылся ли текст
        actual = mainPage.isAnswerDisplayed(questionNumber);
        Assert.assertTrue("Expect: price and payment text is displayed", actual);
    }

}
