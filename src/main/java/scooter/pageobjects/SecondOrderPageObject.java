package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPageObject {
    private final WebDriver driver;
    // когда привезти
    private final By whenToBring = By.xpath("//*[contains(@class,'react')]//input[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private final By rentalPeriod = By.xpath("//*[contains(@class,'Drop')]//span[@class='Dropdown-arrow']");
    // цвет самоката "черный жемчуг"
    private final By scooterColorBlack = By.id("black");
    // цвет самоката "серый"
    private final By scooterColorGrey = By.id("grey");
    // комментарии для курьера
    private final By commentsForTheCourier = By.xpath("//*[contains(@class,'Input')]//input[@placeholder='Комментарий для курьера']");
    // отправка формы Заказа
    private final By sendOrderForm = By.xpath("//*[contains(@class,'Button')]//button[text()='Заказать']");
    // окно сподтвержлением заказа
    private final By confirmationOrderWindow = By.className("Order_Modal__YZ-d3");

    public SecondOrderPageObject(WebDriver driver) {
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

    // Клик по кнопке заказть/отправка формы заказа
    public void clickSendOrderForm() {
        driver.findElement(sendOrderForm).click();
    }

    // подтверждение заказа
    public void confirmationOrderWindow() {
        driver.findElement(confirmationOrderWindow).isDisplayed();
    }

    public void secondOrderForm(String inputDate, String dropDownPeriod, String colorId, String comments) {
        setWhenToBring(inputDate);
        setRentalPeriod(dropDownPeriod);
        setScooterColor(colorId);
        setCommentsForTheCourier(comments);
        clickSendOrderForm();
        confirmationOrderWindow();
    }
}
