import Base.Setup;
import Pages.AddToCart;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends Setup {
    Login objectLogin;
    AddToCart objAddToCart;
    @Test(priority = 0)
    public void doLoginValid() throws Exception{
        objectLogin = new Login(driver);
        driver.get("https://www.saucedemo.com/");
        objectLogin.loginCredential("standard_user","secret_sauce");
        //objectLogin.wrongLoginCredential("test@gmail.com","Test@12345");
    }

    @Test(priority = 1)
    public void doAddToCartModule() throws Exception{
        objAddToCart = new AddToCart(driver);
        objectLogin = new Login(driver);
        driver.get("https://www.saucedemo.com/");
        objectLogin.loginCredential("standard_user","secret_sauce");
        objAddToCart.doAddToCart();
    }


    @Test(priority = 2)
    public void doLoginWithInvalid() throws Exception{
        objectLogin = new Login(driver);
        driver.get("https://www.saucedemo.com/");
        //objectLogin.loginCredential("standard_user","secret_sauce");
        objectLogin.wrongLoginCredential("test@gmail.com","Test@12345");

    }

}
