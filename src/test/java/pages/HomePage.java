package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

@Data
public class HomePage {
    private WebDriver driver;
    private Robot robot;

    @FindBy(xpath = "//*[@id=\"right-content\"]/a")
    private WebElement singIn;

    @FindBy(xpath = "//*[@id=\"icon\"]")
    private WebElement searchIcon;

    @FindBy(xpath = "/html/body/ytmusic-app/ytmusic-app-layout/ytmusic-nav-bar/div[2]/ytmusic-search-box/div/div[1]/input")
    private WebElement searchBar;

    @FindBy(xpath = "/html/body/ytmusic-app/ytmusic-app-layout/ytmusic-nav-bar/div[3]/tp-yt-paper-icon-button")
    private WebElement threeDots;

    @FindBy(xpath = "/html/body/ytmusic-app/ytmusic-popup-container/tp-yt-iron-dropdown/div/ytd-multi-page-menu-renderer/div[3]/div[1]/yt-multi-page-menu-section-renderer/div[2]/ytd-compact-link-renderer[2]/a")
    private WebElement settings;

    @FindBy(xpath = "/html/body/ytmusic-dialog/tp-yt-paper-dialog-scrollable/div/div/ytmusic-settings-page/div[2]/ytmusic-setting-category-collection-renderer/div/ytmusic-setting-boolean-renderer/iron-label/tp-yt-paper-toggle-button/div[1]")
    private WebElement toggle;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void GoToSingIn(){
        singIn.click();
    }

    public void SearchForTrack(){
        searchIcon.click();
        searchBar.sendKeys("death of me");
        searchBar.sendKeys(Keys.ENTER);
        // robot.keyPress();
    }
}
