package scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scooter.pageobjects.ElementsQuestionsObject;

import static org.junit.Assert.assertEquals;

/**
 * Проверка блока "Вопросы о важном"
 */

@RunWith(Parameterized.class)
public class ElementsQuestionsTest extends WebdriverSettings {
    private final String elementButton;
    private final String textElement;
    private final String result;

    public ElementsQuestionsTest(String elementButton, String textElement, String result) {
        this.elementButton = elementButton;
        this.textElement = textElement;
        this.result = result;
    }

    // Тестовые данные
    @Parameterized.Parameters(name = "Тестовые данные:{0},{1},{2}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет!", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я живу за МКАДом, привезёте?", "Да, обязательно.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void comparisontText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));    //скролл до блока элементов "Важные вопросы"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector(elementButton)));
        ElementsQuestionsObject objOuestionsObject = new ElementsQuestionsObject(driver);
        objOuestionsObject.elementsQuestionsObject(elementButton, textElement);
        String resultGetText = driver.findElement(By.xpath(".//*[starts-with(text(),'" + textElement + "')]")).getText();
        assertEquals(result, resultGetText);
    }
}
