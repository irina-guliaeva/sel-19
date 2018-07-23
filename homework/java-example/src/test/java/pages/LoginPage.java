package pages;

import helpers.Litecart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{




    WebDriver driver;

    public LoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="username")
    private WebElement usernameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(name="login")
    private WebElement loginBtn;

    public void loginAs(String login, String password){
        fill(usernameField, login);
        fill(passwordField, password);
        click(loginBtn);
    }

    public void loginAsAdmin(){
        loginAs(Litecart.ADMIN_LOGIN, Litecart.ADMIN_PSW);
    }



}
