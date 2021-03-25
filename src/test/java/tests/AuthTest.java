package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

public class AuthTest {
    private static WebDriver driver;
    private WebDriverWait waitDriver;
    private HomePage homePage;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void GoToSingInPageTest() {
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.getSingIn().click();
        Assert.assertEquals("YouTube", driver.getTitle());
    }

//    @Test
//    public void LogInTest() {
//        driver.get("https://music.youtube.com/");
//        homePage = new HomePage(driver);
//        homePage.GoToSingIn();
//        LoginPage loginPage = new LoginPage(driver);
//        String username = "musicapptest091@gmail.com";
//        String pass = "musicapptest091_!";
//
//        try {
//            loginPage.LoginUser(username, pass);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Assert.assertEquals("https://music.youtube.com/", driver.getCurrentUrl());
//    }

    @Test
    public void OpenSettingsTest(){
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.getThreeDots().click();
        homePage.getSettings().click();
    }

    @Test
    public void TurnOnRestrictedMode(){
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.getThreeDots().click();
        homePage.getSettings().click();
        homePage.getToggle().click();
    }

}
