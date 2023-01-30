package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    // Заголовок страницы
    private By header = By.className("Home_Header__iJKdX");
    // Кнопка статус заказа
    private By orderStatus = By.xpath("//button[contains(text(),'Статус заказа')]");

    // Кнопка заказть верхняя
    private By OrderUpBtn = By.className("Button_Button__ra12g");
    // Кнопка заказть нижняя
    private By OrderDownBtn = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    // Первый вопрос
    private By question1 = By.id("accordion__heading-0");
    // Второй вопрос
    private By question2 = By.id("accordion__heading-1");
    // Пятый вопрос
    private By question3 = By.id("accordion__heading-2");

    private By confirmCookieBtn = By.id("rcc-confirm-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickConfirmCookie(){
        driver.findElement(confirmCookieBtn).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void clickOnOrderBtnUp() {
        driver.findElement(OrderUpBtn).isEnabled();
        driver.findElement(OrderUpBtn).click();
    }

    public void waitForLoadHomePage(String text) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(orderStatus, text));
    }

}