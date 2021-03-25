package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class SearchTest {
    private static WebDriver driver;
    private HomePage homePage;

    @Before
    public void before(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @Test
    public void SearchForTrackTest(){
        driver.get("https://music.youtube.com/");
        homePage = new HomePage(driver);
        homePage.SearchForTrack();
        Assert.assertEquals("https://music.youtube.com/search?q=death+of+me", driver.getCurrentUrl());
    }
}
