package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;

public class Login {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement userSubmitBtn;

    @FindBy(xpath = "//button[contains(@id,'react-burger-menu-btn')]")
    WebElement clickDropdown;

    @FindBy(xpath = "//a[contains(@id,'logout_sidebar_link')]")
    WebElement clickLogoutBtn;

    @FindBy(xpath = "//h3[contains(.,'Epic sadface: Username and password do not match any user in this service')]")
    WebElement getBtnText;




    public Login(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void loginCredential(String email, String password) throws InterruptedException{
        userNameField.sendKeys(email);
        userPasswordField.sendKeys(password);
        userSubmitBtn.click();
        //clickDropdown.click();
        Thread.sleep(3000);
        //clickLogoutBtn.click();
    }



    public void wrongLoginCredential(String email, String password) throws InterruptedException{
        userNameField.sendKeys(email);
        userPasswordField.sendKeys(password);
        userSubmitBtn.click();
        Thread.sleep(3000);
        String assertBtnText= getBtnText.getText();
        Assert.assertEquals(assertBtnText,"Epic sadface: Username and password do not match any user in this service");


    }

}
