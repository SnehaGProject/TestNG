package tests;

import base.baseClass;
import listeners.retryAnalyzer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;


@Listeners({listeners.testListener.class,listeners.suiteListener.class})
public class loginTest extends baseClass {

   @Test(groups={"smoke"})
    public void test1(){
        System.out.println("Test1 execution started :");
        test.assignCategory("smoke");
        test.info("test1 has started");
        Assert.assertTrue(true);
    }
//
//
//
    @Test(retryAnalyzer = retryAnalyzer.class,groups={"regression"})
    public void test2(){
        System.out.println("Test2 execution started :");
        test.assignCategory("regression");
        Assert.assertTrue(false);
    }
//
//    @Test()
//    public void disabledTest(){
//        System.out.println("DisabledTest execution started :");
//        Assert.assertTrue(true);
//    }
//
    @Test(retryAnalyzer = retryAnalyzer.class,groups={"regression"})
    public void test4(){
        System.out.println("Test4 execution started :");
        test.info("test4 has started");
        test.assignCategory("regression");
        Assert.assertTrue(true);
    }

    @Test(priority = 1, groups = {"smoke"}, dataProvider = "loginData")
    public void loginTest(String username, String password) {
       test.assignCategory("smoke");
        LoginPage login = new LoginPage(driver);
        test.info("now we are logging into the website");
        login.login(username, password);
        WebElement productTitle=driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        boolean display= productTitle.isDisplayed();
        Assert.assertTrue(display);
        //Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void addToCartTest() {
//        CartPage cart = new CartPage(driver);
//        cart.addItemToCart();
        Assert.assertTrue(true);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };
    }
}
