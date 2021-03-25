package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

@Data
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait waitDriver;

    @FindBy(id = "identifierId")
    private WebElement email;

    @FindBy(id = "identifierNext")
    private WebElement next;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement password;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void LoginUser(String username, String pass) throws InterruptedException {
        email.sendKeys(username);
        next.click();

        System.out.println(driver.getCurrentUrl());
        waitDriver = new WebDriverWait(driver, 20);
        waitDriver.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")), "Добро пожаловать!"));
        password.sendKeys(pass);
        next.click();
    }
}
