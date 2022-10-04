package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

// Создаем класс окна с вопросом о подтверждении заказа
public class ConfirmQuestionPage {

    // Поля класса
    private final WebDriver driver; // Поле driver
    // Локатор вопроса о подтверждении заказа
    private static final By CONFIRM_QUESTION = By.cssSelector("div.Order_ModalHeader__3FDaJ");
    // Локатор кнопки подтверждения заказа
    private static final By CONFIRM_BUTTON = By.xpath(".//button[text()='Да']");


    // Конструктор класса ConfirmQuestionPage
    public ConfirmQuestionPage(WebDriver driver) {
        this.driver = driver; // Инициализировали поле driver
    }

    // Метод проверяет, отображается ли вопрос о подтверждении заказа
    public void isConfirmQuestionVisible() {
        driver.findElement(CONFIRM_QUESTION).isDisplayed();
    }

   // Метод проверяет, актична ли кнопка подтверждения заказа
    public boolean isConfirmButtonEnable() {
        return driver.findElement(CONFIRM_BUTTON).isEnabled();
    }

    // Метод кликает по кнопке подтверждения заказа
    public void clickConfirmButton() {
        driver.findElement(CONFIRM_BUTTON).click();
//        Point location = driver.findElement(CONFIRM_BUTTON).getLocation();
//        System.out.println(location);
//        int x = location.getX();
//        int y = location.getY();
//
//
////        Actions actions = new Actions(driver);
//////        actions.moveToElement(driver.findElement(By.cssSelector("div.Order_Modal__YZ-d3")), 0, 0);
////        actions.moveByOffset(location.getX(), location.getY()).click().perform();
//
//        ((JavascriptExecutor) driver).
//                    executeScript
//                            ("element = document.elementFromPoint(503, 496); element.click();");




//
//        new Actions(driver).moveByOffset(x coordinate, y coordinate).click().build().perform();
//        new Actions(driver).moveByOffset(-x coordinate, -y coordinate).perform();
////        Also, note that x and y co-ordinates are relative values from current mouse position.
////        Assuming mouse co-ordinates are at (0,0) to start with, if you want to use absolute values,
////        you can perform the below action immediately after you clicked on it using the above code.
//
////        This worked for me in Java for clicking on coordinates irrespective on any elements.
////        Second line of code will reset your cursor to the top left corner of the browser view and last line will click on the x,y coordinates provided as parameter.
//                Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
//        actions.moveByOffset(xCoordinate, yCoordinate).click().build().perform();
//
////        In Selenium Java, you can try it using Javascript:
//        WebDriver driver = new ChromeDriver();
//        if (driver instanceof JavascriptExecutor) {
//            ((JavascriptExecutor) driver).
//                    executeScript("el = document.elementFromPoint(x-cordinate, y-cordinate); el.click();");
//        }
//
////        Action chains can be a little finicky. You could also achieve this by executing javascript.
//                self.driver.execute_script('el = document.elementFromPoint(440, 120); el.click();')


    }

}

