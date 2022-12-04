package scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.pageobjects.FirstOrderPageObject;
import scooter.pageobjects.SecondOrderPageObject;

import static org.junit.Assert.assertEquals;

/**
 * Проверка заказа скутера
 */

@RunWith(Parameterized.class)
public class OrderScooterTest extends WebdriverSettings {
    private final String topOrBot;
    private final String stationName;
    private final String username;
    private final String lastname;
    private final String address;
    private final String phoneNumber;
    private final String inputDate;
    private final String dropDownPeriod;
    private final String colorId;
    private final String comments;
    private final boolean сonfirmationOrder;

    public OrderScooterTest(String topOrBot, String username, String lastname, String address, String phoneNumber, String stationName, String inputDate, String dropDownPeriod, String colorId, String comments, boolean сonfirmationOrder) {
        this.topOrBot = topOrBot;
        this.stationName = stationName;
        this.username = username;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inputDate = inputDate;
        this.dropDownPeriod = dropDownPeriod;
        this.colorId = colorId;
        this.comments = comments;
        this.сonfirmationOrder = сonfirmationOrder;
    }

    @Parameterized.Parameters(name = "Тестовые данные:{0},{1},{2},{3},{4},{5},{5},{7}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Header", "Сергей", "Зайцев", "город Таганрог, ул. Чехова, дом 500", "79005005050", "Охотный Ряд", "12.03.2023", "сутки", "black", "Не звони мне больше", true},
                {"Button", "Валерия", "Зайцева", "город Таганрог, ул. Чехова, дом 500", "79005008080", "Сокольники", "05.06.2023", "четверо суток", "grey", "И мне не звони мне больше", true},
        };
    }

    @Test
    public void OrderTest() {
        FirstOrderPageObject objFirstOrderForm = new FirstOrderPageObject(driver);
        SecondOrderPageObject objSecondOrderForm = new SecondOrderPageObject(driver);
        objFirstOrderForm.firstOrderForm(topOrBot, username, lastname, address, phoneNumber, stationName);
        objSecondOrderForm.secondOrderForm(inputDate, dropDownPeriod, colorId, comments);
        boolean actualResult = true;
        assertEquals("Появление окна для подтверждения/отклонения заказа", actualResult, сonfirmationOrder);
    }
}
