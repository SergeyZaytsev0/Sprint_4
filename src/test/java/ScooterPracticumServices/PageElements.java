package ScooterPracticumServices;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

class PageЕlements {
    // Логотип "Яндекс"
    private By Yandex = By.cssSelector("[alt = 'Yandex']");
    // Логотип "Самокат"
    private By Scooter = By.cssSelector("[alt = 'Scooter']");
    // Верхняя кнопка "Заказать"
    private By OrderTop = By.className("Button_Button__ra12g");
    // Статус заказа
    private By OrderStatus = By.className("Header_Link__1TAG7");

    // Нижняя конапка "Заказать"
    private By OrderBottom = By.xpath("//*[@id=\"root\"]//div[1]/div[2]/button[1]");

    //Сколько это стоит? И как оплатить?
    private By howToPay = By.xpath("\"//*[contains(text(),'Сколько это стоит? И как оплатить?')]\"");
    //Хочу сразу несколько самокатов! Так можно?
    private By severalScooters = By.xpath("\"//*[contains(text(),'Хочу сразу несколько самокатов! Так можно?')]\"");
    //Как рассчитывается время аренды?
    private By rentalTime = By.xpath("\"//*[contains(text(),'Как рассчитывается время аренды?')]\"");
    //Можно ли заказать самокат прямо на сегодня?
    private By orderForToday = By.xpath("\"//*[contains(text(),'Можно ли заказать самокат прямо на сегодня?')]\"");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By extendTheOrder = By.xpath("\"//*[contains(text(),'Можно ли продлить заказ или вернуть самокат раньше?')]\"");
    //Вы привозите зарядку вместе с самокатом?
    private By scooterCharging = By.xpath("\"//*[contains(text(),'Вы привозите зарядку вместе с самокатом?')]\"");
    //Можно ли отменить заказ?
    private By cancelTheOrder = By.xpath("\"//*[contains(text(),'Можно ли отменить заказ?')]\"");
    //Я живу за МКАДом, привезёте?
    private By liveOutside = By.xpath("\"//*[contains(text(),'Я живу за МКАДом, привезёте?')]\"");
    }



