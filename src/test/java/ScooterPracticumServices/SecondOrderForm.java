package ScooterPracticumServices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderForm {
    private WebDriver driver;

    // когда привезти
    private By whenToBring = By.xpath("//*[contains(@class,'react')]//input[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private By rentalPeriod = By.xpath("//*[contains(@class,'Drop')]//span[@class='Dropdown-arrow']");
    // цвет самоката "черный жемчуг"
    private By scooterColorBlack = By.id("black");
    // цвет самоката "серый"
    private By scooterColorGrey = By.id("grey");
    // комментарии для курьера
    private By commentsForTheCourier = By.xpath("//*[contains(@class,'Input')]//input[@placeholder='Комментарий для курьера']");
    // отправка формы Заказа
    private By sendOrderForm = By.xpath("//*[contains(@class,'Button')]//button[text()='Заказать']");

    public SecondOrderForm(WebDriver driver) {
        this.driver = driver;
    }

    // Выбор даты доставки
    public void setWhenToBring(String inputDate) {

        driver.findElement(whenToBring).sendKeys(inputDate);
    }

    // Выбор срока аренды
    public void setRentalPeriod(String dropDownPeriod) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath("//*[contains(@class,'Drop')]//div[text()='" + dropDownPeriod + "']")).click();
    }

    // Выбор цвета
    public void setScooterColor(String colorId) {
        driver.findElement(By.id("" + colorId + "")).click();

    }

    // Заполнение комментария курьеру
    public void setCommentsForTheCourier(String comments) {
        driver.findElement(commentsForTheCourier).sendKeys(comments);
    }

    //
    public void clickSendOrderForm() {
        driver.findElement(sendOrderForm).click();
    }

    public void secondOrderForm(String inputDate, String dropDownPeriod, String colorId, String comments) {
        setWhenToBring(inputDate);
        setRentalPeriod(dropDownPeriod);
        setScooterColor(colorId);
        setCommentsForTheCourier(comments);
        clickSendOrderForm();

    }
}
