package pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class ExplorePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"items\"]/ytmusic-navigation-button-renderer[1]/button")
    private WebElement releases;

    @FindBy(xpath = "//*[@id=\"items\"]/ytmusic-two-row-item-renderer/a")
    private WebElement albom;

    @FindBy(xpath = "//*[@id=\"play-button\"]/div")
    private WebElement song;

    public ExplorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
