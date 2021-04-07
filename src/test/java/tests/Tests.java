package tests;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ExplorePage;
import pages.HomePage;

import java.net.URL;

public class Tests {
    private static WebDriver driver;
    private WebDriverWait waitDriver;
    private HomePage homePage;
    private ExplorePage explorePage;

    @SneakyThrows
    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");

        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        driver = new RemoteWebDriver(
                new URL("http://"+System.getProperty("host") + ":4444/wd/hub/"), options);

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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

    // expected to fail
    @Test
    public void TurnOnRestrictedMode(){
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.getThreeDots().click();
        homePage.getSettings().click();
        homePage.getToggle().click();
    }

    @Test
    public void SearchForTrackTest(){
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.SearchForTrack();

        // Assert.assertEquals("https://music.youtube.com/search?q=death+of+me", driver.getCurrentUrl());
    }

    @Test
    public void LaunchNewReleaseTest(){
        driver.get("https://music.youtube.com/explore");
        explorePage = new ExplorePage(driver);
        explorePage.getReleases().click();
        explorePage.getAlbom().click();
        explorePage.getSong().click();
    }

}
