package Pages;

import Base.Setup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddToCart extends Setup {
    WebDriver driver;
    @FindBy(xpath="//button[contains(@id,'add-to-cart-sauce-labs-backpack')]")
    WebElement addTOCartBtn1;
    @FindBy(xpath="//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]")
    WebElement addTOCartBtn2;
    @FindBy(xpath="//button[contains(@id,'add-to-cart-sauce-labs-bolt-t-shirt')]")
    WebElement addTOCartBtn3;
    @FindBy(xpath="//a[contains(@class,'shopping_cart_link')]")
    WebElement clickAddToCartBtn;

    @FindBy(xpath = "//button[contains(@id,'checkout')]")
    WebElement clickCheckoutBtn;

    @FindBy(xpath = "//input[contains(@id,'first-name')]")
    WebElement clickCheckoutName;
    @FindBy(xpath = "//input[contains(@id,'last-name')]")
    WebElement clickCheckoutLastName;
    @FindBy(xpath = "//input[contains(@id,'postal-code')]")
    WebElement clickCheckoutZip;

    @FindBy(xpath = "//input[contains(@id,'continue')]")
    WebElement clickCheckoutContinueBtn;

    @FindBy(xpath = "//button[contains(@id,'finish')]")
    WebElement clickCheckoutFinishBtn;



    public AddToCart(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void doAddToCart() throws  InterruptedException{
        addTOCartBtn1.click();
        Thread.sleep(3000);
        addTOCartBtn2.click();
        Thread.sleep(3000);
        addTOCartBtn3.click();
        Thread.sleep(3000);
        clickAddToCartBtn.click();
        Thread.sleep(3000);
        clickCheckoutBtn.click();
        Thread.sleep(3000);
        clickCheckoutName.sendKeys("pappu");
        Thread.sleep(3000);
        clickCheckoutLastName.sendKeys("Islam");
        Thread.sleep(3000);
        clickCheckoutZip.sendKeys("1212");
        Thread.sleep(3000);
        clickCheckoutContinueBtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(3000);
        clickCheckoutFinishBtn.click();

    }

    public void takeScreenShot() throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File DestFile = new File(fileWithPath);

        FileUtils.copyFile(screenshotFile, DestFile);

    }

}
