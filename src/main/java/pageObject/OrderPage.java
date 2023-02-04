package pageObject;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class OrderPage {
    private WebDriver driver;
  /* Для кого Скутер   */
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By metroStationTuskaya = By.xpath("//input[@placeholder='* Станция метро'][@value='Тульская']");
    private final By telephoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By  nextBtn = By.xpath("//button[contains(text(),'Далее')]");

    /* Про аренду Скутера   */
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By dateToday = By.xpath("//div[contains(@class,'today')]");

    private final By periodField = By.xpath("//div[@class='Dropdown-placeholder'][contains(text(),'* Срок аренды')]");
    private final By periodTwoDay = By.xpath("//div[@role='option'][contains(text(),'двое суток')]");
    private final By colorScooter = By.id("black");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderBtnOnRentPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By yesOrderBtn = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']");

    private final By orderCompletePopUp = By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage(){

    }


    public void checkOrderConfirmPopUpByText(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElementLocated(orderCompletePopUp, text));
        MatcherAssert.assertThat(text,is("Заказ оформлен"));
        System.out.println(text);

    }


    public void setName(String name){
        driver.findElement(nameField).isEnabled();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurName(String surName){
        driver.findElement(surnameField).isEnabled();
        driver.findElement(surnameField).sendKeys(surName);
    }
    public void setAddressField(String address){
        driver.findElement(addressField).isEnabled();
        driver.findElement(addressField).sendKeys(address);
    }
    public void setMetroStation(String metroStation){

        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(metroStationField).sendKeys(Keys.DOWN);
        driver.findElement(metroStationField).sendKeys(Keys.RETURN);


    }
    public void setTelephoneNumber(String telephoneNumber){
        driver.findElement(telephoneNumberField).isEnabled();
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }
    public void clickOnNextBtn(){
        driver.findElement(nextBtn).click();
    }
    public void clickOnNextBtnNotClickable(){
        driver.findElement(nextBtn).click();
        driver.findElement(nextBtn).isDisplayed();
    }

    public void setDataRent(){
        driver.findElement(dateField).isEnabled();
        driver.findElement(dateField).click();
        driver.findElement(dateToday).click();

    }
    public void setPeriod(){
        driver.findElement(periodField).click();
        driver.findElement(periodTwoDay).click();
    }

    public void selectColor(){
        driver.findElement(colorScooter).click();
    }
    public void setComment(String comment){
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOnOrderBtnOnRentPage(){
        driver.findElement(orderBtnOnRentPage).isEnabled();
        driver.findElement(orderBtnOnRentPage).click();
    }

    public void clickYesOrderBtn(){
        driver.findElement(yesOrderBtn).isEnabled();
        driver.findElement(yesOrderBtn).sendKeys(Keys.ENTER);
    }

    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }


}
