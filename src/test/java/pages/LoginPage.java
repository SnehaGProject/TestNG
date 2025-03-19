package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //@FindBy(xpath="");
    @FindBy(xpath="//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath="//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='login-button']")
    WebElement login;

    public void login(String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();
    }
}
