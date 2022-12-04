package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstOrderPageObject {
    private final WebDriver driver;

    // кнопка Заказать
    private final By orderTop = By.xpath("//*[contains(@class, 'Header')]//button[text()='Заказать']");
    // локатор поля ввода «Имени»
    private final By inputName = By.xpath(".//*[@Placeholder='* Имя']");
    // локатор поля ввода «Фамилии»
    private final By inputLastName = By.xpath(".//*[@Placeholder='* Фамилия']");
    // локатор поля ввода «Адреса»
    private final By addresToBring = By.xpath("//*[@Placeholder='* Адрес: куда привезти заказ']");
    // локатор поля выбора «Метро»
    private final By MetroStation = By.xpath(".//*[@Placeholder='* Станция метро']");
    // локатор поля ввода «Номера телефона»
    private final By inputPhoneNumber = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    // нажатие на кнопку "Далее"
    private final By buttonFurther = By.xpath("//*[contains(@class,'Button')]//*[text()='Далее']");
    // нижняя кнопка "Заказать"
    private final By orderBot = By.xpath("//*[contains(@class, 'Button')]//*[text()='Заказать']");
    // hпинять все куки
    private final By cookieButton = By.xpath("//*[contains(@class, 'App')]//*[text()='да все привыкли']");

    public FirstOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    // метод кликает по кнопке «Заказать»
    public void clickOrderButton(String topOrBottom) {
        driver.findElement(cookieButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderTop));
        //скролл до блока элементов "Важные вопросы"
        WebElement element = driver.findElement(By.xpath("//*[contains(@class, '" + topOrBottom + "')]//button[text()='Заказать']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//*[contains(@class, '" + topOrBottom + "')]//button[text()='Заказать']")).click();
    }

    //метод заполняет поля «Имя»
    public void setInputName(String username) {
        driver.findElement(inputName).sendKeys(username);
    }

    //метод заполняет поля «Фамилия»
    public void setLastName(String lastname) {
        driver.findElement(inputLastName).sendKeys(lastname);
    }

    //метод заполняет поля «Адрес»
    public void setAddresToBring(String address) {
        driver.findElement(addresToBring).sendKeys(address);
    }

    // метод выбора станции метро
    public void selectValueInDropdown(String stationName) {
        driver.findElement(MetroStation).click();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'select-search')]//ul")));
        driver.findElement(By.xpath("//*[contains(@class, 'select-search')]//*[text()='" + stationName + "']")).click();
    }

    //метод заполняет поля «Телефон»
    public void setInputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    // нажатие на кнопку "далее"
    public void setButtonFurther() {
        driver.findElement(buttonFurther).click();
    }

    public void firstOrderForm(String topOrBot, String username, String lastname, String address, String phoneNumber, String stationName) {
        clickOrderButton(topOrBot);
        selectValueInDropdown(stationName);
        setInputName(username);
        setLastName(lastname);
        setAddresToBring(address);
        setInputPhoneNumber(phoneNumber);
        setButtonFurther();
    }

}
