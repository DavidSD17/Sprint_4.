import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.HomePage;
import pageObject.OrderPage;

public class Tests_OrderPage {
    private WebDriver driver;


    @Test
    public void setDataClientForCreateOrderFirefox() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtnUp();
        orderPage.setName("Иван");
        orderPage.setSurName("Сидоров");
        orderPage.setMetroStation("Тульская");
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
    @Test
    public void setDataClientForCreateOrderChrome() {

         driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtnUp();
        orderPage.setName("Ivan");
        orderPage.setSurName("Petrov");
        orderPage.setMetroStation("Сокольники");
        orderPage.setAddressField("г Москва, Новоданиловская наб, д 4А, кв.1");
        orderPage.setTelephoneNumber("89521112233");
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