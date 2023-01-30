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
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    private By metroStationTuskaya = By.xpath("//input[@placeholder='* Станция метро'][@value='Тульская']");
    private By telephoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By  nextBtn = By.xpath("//button[contains(text(),'Далее')]");

    /* Про аренду Скутера   */
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By dateToday = By.xpath("//div[contains(@class,'today')]");

    private By periodField = By.xpath("//div[@class='Dropdown-placeholder'][contains(text(),'* Срок аренды')]");
    private By periodTwoDay = By.xpath("//div[@role='option'][contains(text(),'двое суток')]");
    private By colorScooter = By.id("black");
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By orderBtnOnRentPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By yesOrderBtn = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']");
    private By orderNumberPopUp = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]/div/text()[2]");
    private By orderCompletePopUp = By.xpath("//div[@class='Order_ModalHeader__3FDaJ'][text()='Заказ оформлен']");
    private By viewOrderStatus = By.xpath("//button[contains(text(),'Посмотреть статус')]");
    private By orderNumberInStatus = By.className("Input_Input__1iN_Z Track_Input__1g7lq Input_Filled__1rDxs Input_Responsible__1jDKN");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void checkPopUpConfirmOrder(String expected){
            String expected1 = "";
            String actual = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]/text()")).getText();
        MatcherAssert.assertThat(expected1, is(actual));
        System.out.println(actual);

    }
    public void checkOrderConfirmPopUpByText(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElementLocated(orderCompletePopUp, text));
        MatcherAssert.assertThat(text,is("Заказ оформлен"));
        System.out.println(text);

    }


    public void clickViewOrderStatus(){
        driver.findElement(viewOrderStatus).isEnabled();
        driver.findElement(viewOrderStatus).click();
    }
    public String getOrderNumber(){
      driver.findElement(orderNumberInStatus).isEnabled();
       return driver.findElement(orderNumberInStatus).getText();
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
