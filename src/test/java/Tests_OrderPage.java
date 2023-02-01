import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.HomePage;
import pageObject.OrderPage;

public class Tests_OrderPage {
    private WebDriver driver;
    private By orderBtn;


    @Before
    public void setUpChrome(){
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void setDataClientForCreateOrderChrome() {

        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtn(orderBtn);
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
    public void setDataClientForCreateOrderChrome1() {

        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtn(orderBtn) ;
        orderPage.setName("Ivan");
        orderPage.setSurName("Petrov");
        orderPage.setMetroStation("Сокольники");
        orderPage.setAddressField("г Москва, Новоданиловская наб, д 4А, кв.1");
        orderPage.setTelephoneNumber("89521112233");
        orderPage.clickOnNextBtnNotClickable();;


    }



    @Before
    public void setUpFireFox(){
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
    @Test
    public void setDataClientForCreateOrder() {

        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtn(orderBtn);
        orderPage.setName("Ivan");
        orderPage.setSurName("Petrov");
        orderPage.setMetroStation("Сокольники");
        orderPage.setAddressField("г Москва, Новоданиловская наб, д 4А, кв.1");
        orderPage.setTelephoneNumber("89521112233");
        orderPage.clickOnNextBtnNotClickable();


    }

    @Test
    public void setDataClientForCreateOrderFirefox() {

        OrderPage orderPage = new OrderPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage("Статус заказа");
        homePage.clickConfirmCookie();
        homePage.clickOnOrderBtn(orderBtn);
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

    @After
    public void tearDown(){
        driver.quit();
    }

    @After
    public void tearDownChrome(){
        driver.quit();
    }
}