package ScooterPracticumServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Проверка заказа скутера
 */

@RunWith(Parameterized.class)
public class OrderScooter extends WebdriverSettings {
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

    public OrderScooter(String topOrBot, String username, String lastname, String address, String phoneNumber, String stationName, String inputDate,String dropDownPeriod, String colorId, String comments) {
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
    }
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Header", "Сергей", "Зайцев","город Таганрог, ул. Чехова, дом 500","79005005050","Охотный Ряд","12.03.2023","сутки","black","Не звони мне больше"},
                {"Button", "Валерия", "Зайцева","город Таганрог, ул. Чехова, дом 500","79005008080","Сокольники","05.06.2023","четверо суток","grey","И мне не звони мне больше"},
        };
    }

    @Test
    public void OrderTest(){
        FirstOrderForm objFirstOrderForm = new FirstOrderForm(driver);
        SecondOrderForm objSecondOrderForm = new SecondOrderForm(driver);
        objFirstOrderForm.firstOrderForm(topOrBot,username,lastname,address,phoneNumber,stationName);
        objSecondOrderForm.secondOrderForm(inputDate,dropDownPeriod,colorId,comments);
    }
}
