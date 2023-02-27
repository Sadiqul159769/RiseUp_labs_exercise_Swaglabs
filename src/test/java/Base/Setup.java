package Base;

import Pages.AddToCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Setup {
   public WebDriver driver;
    @BeforeTest
    public  void setup_file() throws IOException {
       driver = new ChromeDriver();
       driver.manage().window();
       //driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void ScreenShot(ITestResult result) throws IOException {
        if (ITestResult.SUCCESS == result.getStatus()) {
            try {
                AddToCart util = new AddToCart(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }




//    @AfterTest
//    public void logout(){
//        driver.close();
//    }
}
