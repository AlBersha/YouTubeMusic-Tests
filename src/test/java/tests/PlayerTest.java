package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ExplorePage;
import pages.HomePage;

public class PlayerTest {
    private static WebDriver driver;
    private ExplorePage explorePage;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
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
