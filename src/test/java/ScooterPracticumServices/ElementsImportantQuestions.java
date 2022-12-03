package ScooterPracticumServices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;


/**
 * Проверка блока "Вопросы о важном"
 */

@RunWith(Parameterized.class)
public class ElementsImportantQuestions extends WebdriverSettings{
    private final String elementButton;
    private final String textElement;
    private final String result;

    public ElementsImportantQuestions(String elementButton, String textElement, String result) {
        this.elementButton = elementButton;
        this.textElement = textElement;
        this.result = result;
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"//*[contains(text(),'Сколько это стоит? И как оплатить?')]", ".//*[starts-with(text(),'Сутки')]", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"//*[contains(text(),'Хочу сразу несколько самокатов! Так можно?')]", ".//*[starts-with(text(),'Пока что у нас')]","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"//*[contains(text(),'Как рассчитывается время аренды?')]", ".//*[starts-with(text(),'Допустим')]","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"//*[contains(text(),'Можно ли заказать самокат прямо на сегодня?')]", ".//*[starts-with(text(),'Только начиная')]","Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"//*[contains(text(),'Можно ли продлить заказ или вернуть самокат раньше?')]", ".//*[starts-with(text(),'Пока что нет!')]","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"//*[contains(text(),'Вы привозите зарядку вместе с самокатом?')]", ".//*[starts-with(text(),'Самокат приезжает')]","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"//*[contains(text(),'Можно ли отменить заказ?')]", ".//*[starts-with(text(),'Да, пока самокат')]","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"//*[contains(text(),'Я живу за МКАДом, привезёте?')]", ".//*[starts-with(text(),'Да, обязательно.')]","Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    @Test
    public void comparisontText() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = driver.findElement(By.className("Home_FourPart__1uthg"));    //скролл до блока элементов "Важные вопросы"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.cssSelector(elementButton)));
        driver.findElement(By.xpath(elementButton)).click();
        driver.findElement(By.xpath(textElement)).getText();
        assertEquals(result, driver.findElement(By.xpath(textElement)).getText());
    }
}
