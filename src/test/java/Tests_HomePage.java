import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.HomePage;

public class Tests_HomePage extends HomePage {
    private WebDriver driver;

    public Tests_HomePage() {
        super();
    }


    @Test
    public void checkQuestion1Chrome() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.clickQuestion(question1);
        homePage.checkAnswer(answer1Locator,answer1);

    }

    @Test
    public void checkQuestion2Chrome() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.clickQuestion(question2);
        homePage.checkAnswer(answer2Locator,answer2);

    }
    @Test
    public void checkQuestion7Chrome() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePage homePage = new HomePage(driver);
        homePage.clickQuestion(question7);
        homePage.checkAnswer(answer7Locator,answer7);

    }

    @Test
    public void checkHeaderText() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);

        homePage.clickQuestion(question7);
        homePage.checkAnswer(answer7Locator,answer7);

    }


    @After
    public void tearDown() {

        driver.quit();
    }


}
