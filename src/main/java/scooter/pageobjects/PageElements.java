package scooter.pageobjects;

import org.openqa.selenium.By;

class PageЕlements {
    // Логотип "Яндекс"
    private final By Yandex = By.cssSelector("[alt = 'Yandex']");
    // Логотип "Самокат"
    private final By Scooter = By.cssSelector("[alt = 'Scooter']");
    // Верхняя кнопка "Заказать"
    private final By OrderTop = By.xpath("//*[contains(@class, 'Header')]//button[text()='Заказать']");
    // Статус заказа
    private final By OrderStatus = By.xpath("//*[contains(@class, 'Header')]//*[text()='Статус заказа']");
    // Нижняя конапка "Заказать"
    private final By OrderBottom = By.xpath("//*[contains(@class, 'Button')]//button[text()='Заказать']");
    //Сколько это стоит? И как оплатить?
    private final By howToPay = By.xpath("\"//*[contains(text(),'Сколько это стоит? И как оплатить?')]\"");
    //Хочу сразу несколько самокатов! Так можно?
    private final By severalScooters = By.xpath("\"//*[contains(text(),'Хочу сразу несколько самокатов! Так можно?')]\"");
    //Как рассчитывается время аренды?
    private final By rentalTime = By.xpath("\"//*[contains(text(),'Как рассчитывается время аренды?')]\"");
    //Можно ли заказать самокат прямо на сегодня?
    private final By orderForToday = By.xpath("\"//*[contains(text(),'Можно ли заказать самокат прямо на сегодня?')]\"");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private final By extendTheOrder = By.xpath("\"//*[contains(text(),'Можно ли продлить заказ или вернуть самокат раньше?')]\"");
    //Вы привозите зарядку вместе с самокатом?
    private final By scooterCharging = By.xpath("\"//*[contains(text(),'Вы привозите зарядку вместе с самокатом?')]\"");
    //Можно ли отменить заказ?
    private final By cancelTheOrder = By.xpath("\"//*[contains(text(),'Можно ли отменить заказ?')]\"");
    //Я живу за МКАДом, привезёте?
    private final By liveOutside = By.xpath("\"//*[contains(text(),'Я живу за МКАДом, привезёте?')]\"");
}



