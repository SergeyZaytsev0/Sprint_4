package scooter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsQuestionsObject {
    private final WebDriver driver;
    // Сколько это стоит? И как оплатить?
    private final By howToPay = By.xpath("//*[contains(text(),'Сколько это стоит? И как оплатить?')]");
    // Ответ на первый вопрос
    private final By firstQuestion = By.xpath(".//*[starts-with(text(),'Сутки')]");
    // Хочу сразу несколько самокатов! Так можно?
    private final By severalScooters = By.xpath("//*[contains(text(),'Хочу сразу несколько самокатов! Так можно?')]");
    // Как рассчитывается время аренды?
    private final By rentalTime = By.xpath("//*[contains(text(),'Как рассчитывается время аренды?')]");
    // Можно ли заказать самокат прямо на сегодня?
    private final By orderForToday = By.xpath("//*[contains(text(),'Можно ли заказать самокат прямо на сегодня?')]");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private final By extendTheOrder = By.xpath("//*[contains(text(),'Можно ли продлить заказ или вернуть самокат раньше?')]");
    // Вы привозите зарядку вместе с самокатом?
    private final By scooterCharging = By.xpath("//*[contains(text(),'Вы привозите зарядку вместе с самокатом?')]");
    // Можно ли отменить заказ?
    private final By cancelTheOrder = By.xpath("//*[contains(text(),'Можно ли отменить заказ?')]");
    // Я живу за МКАДом, привезёте?
    private final By liveOutside = By.xpath("//*[contains(text(),'Я живу за МКАДом, привезёте?')]");
    // Ответ на второй вопрос
    private final By secondQuestion = By.xpath(".//*[starts-with(text(),'Пока что у нас')]");
    // Ответ на третий вопрос
    private final By thirdQuestion = By.xpath(".//*[starts-with(text(),'Допустим')]");
    // Ответ на четвертый вопрос
    private final By fourthQuestion = By.xpath(".//*[starts-with(text(),'Только начиная')]");
    // Ответ на пятый вопрос
    private final By fifthQuestion = By.xpath(".//*[starts-with(text(),'Пока что нет!')]");
    // Ответ на шестой вопрос
    private final By sixQuestion = By.xpath(".//*[starts-with(text(),'Самокат приезжает')]");
    // Ответ на седьмой вопрос
    private final By seventhQuestion = By.xpath(".//*[starts-with(text(),'Да, пока самокат')]");
    // Ответ на восьмой вопрос
    private final By eighthQuestion = By.xpath(".//*[starts-with(text(),'Да, обязательно.')]");

    public ElementsQuestionsObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setElementButton(String clickQuestion) {
        driver.findElement(By.xpath("//*[contains(text(),'" + clickQuestion + "')]")).click();
    }

    public void setTextElement(String answerQuestion) {
        driver.findElement(By.xpath(".//*[starts-with(text(),'" + answerQuestion + "')]")).getText();
    }

    public void elementsQuestionsObject(String elementButton, String textElement) {
        setElementButton(elementButton);
        setTextElement(textElement);
    }
}
