import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.HomePage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageObject.OrderPage;

@RunWith(Parameterized.class)
public class ParamTests_CreateOrder extends OrderPage {

    private WebDriver driver;

    private String name;
    private String metroStation;
    private  By orderBtn;

    public static By orderUpBtn = By.className("Button_Button__ra12g");
    // Кнопка заказть нижняя
    public static By orderDownBtn = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public ParamTests_CreateOrder(String name, String metroStation,By orderBtn) {
        this.name = name;
        this.metroStation = metroStation;
        this.orderBtn = orderBtn;

    }

    @Parameterized.Parameters
    public static Object[][] getTestDataOrder() {
        return new Object[][] {
                { "Иван", "Тульская",orderUpBtn},
                { "Иван", "Черкизовская",orderDownBtn},
                { "Ivan", "Тульская",orderUpBtn},

        };
    }

    @Before
    public void setUpFireFox(){
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void setDataClientForCreateOrderFireFox() {

        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtn(orderBtn);
        orderPage.setName(name);
        orderPage.setSurName("Сидоров");
        orderPage.setMetroStation(metroStation);
        orderPage.setAddressField("г Москва, Новоданиловская наб, д 4А, кв.1");
        orderPage.setTelephoneNumber("+71231112233");
        orderPage.clickOnNextBtn();
        orderPage.setDataRent();
        orderPage.setPeriod();
        orderPage.setComment("Тестоввый комментарий !@#$$%%^&12335" );
        orderPage.selectColor();
        orderPage.clickOnOrderBtnOnRentPage();
        orderPage.clickYesOrderBtn();
        orderPage.checkOrderConfirmPopUpByText("Заказ оформлен");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
