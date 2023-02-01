package pageObject;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;

public class HomePage {
    private WebDriver driver;

    // Заголовок страницы
    private final By header = By.className("Home_Header__iJKdX");
    // Кнопка статус заказа
    private final By orderStatus = By.xpath("//button[contains(text(),'Статус заказа')]");

    // Кнопка заказть верхняя
    public final By orderUpBtn = By.className("Button_Button__ra12g");
    // Кнопка заказть нижняя
    public final By orderDownBtn = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    // Первый вопрос
    public final By question1 = By.id("accordion__heading-0");
    public final By answer1Locator = By.xpath("//*[@id='accordion__panel-0']/p");
    public final  String answer1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    public final By question2 = By.id("accordion__heading-1");
    public final By answer2Locator = By.xpath("//*[@id='accordion__panel-1']/p");
    public final String answer2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    public final By question7 = By.id("accordion__heading-7");
    public final By answer7Locator = By.xpath("//*[@id='accordion__panel-7']/p");
    public final String answer7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private final By confirmCookieBtn = By.id("rcc-confirm-button");
    public  By orderBtn;

    public  HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage() {

    }

    public void clickConfirmCookie(){
        driver.findElement(confirmCookieBtn).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void clickOnOrderBtn(By orderBtn) {
        driver.findElement(orderBtn).isEnabled();
        driver.findElement(orderBtn).click();
    }
    public void clickOnOrderOrderDownBtn() {
        WebElement element = driver.findElement(orderDownBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.isEnabled();
        element.click();
    }

    public void waitForLoadHomePage(String text) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.textToBePresentInElementLocated(orderStatus, text));
    }
    public void clickQuestion(By question) {
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.isEnabled();
        element.click();
    }
    public void checkAnswer(By locator, String answer){

      String actual= driver.findElement(locator).getText();
        MatcherAssert.assertThat(answer,is(actual));
        System.out.println(actual);
    }
    public void clickAndCheck(By question,By locator, String answer){
        WebElement element = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.isEnabled();
        element.click();
        String actual= driver.findElement(locator).getText();
        MatcherAssert.assertThat(answer,is(actual));
        System.out.println(actual);
    }
}