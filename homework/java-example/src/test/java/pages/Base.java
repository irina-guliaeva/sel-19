package pages;

import helpers.Litecart;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Base {

    private MainPage mainPage;
    private ProductPage productPage;
    private Header header;
    private Cart cart;
    private Navigation navigation;
    private LoginPage loginPage;

    public Base(){

    }

    protected final static String CHROME = "ChromeDriver";
    protected final static String FIREFOX = "GeckoDriver";
    protected final static String IE = "IEDriver";
    protected final static String EDGE = "EdgeDriver";

    protected final static String LITECART_ADMIN = "http://localhost/litecart/admin/";
    protected final static String LITECART_MAIN = "http://localhost/litecart";
    protected final static String ADMIN_LOGIN = "admin";
    protected final static String ADMIN_PSW = "admin";

    private final static By LOGIN_FIELD = By.name("username");
    private final static By PSW_FIELD = By.name("password");
    private final static By LOGIN_BTN = By.name("login");

    protected WebDriver driver;
    protected WebDriverWait wait;

    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        temporaryLog("init the ChromeDriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    public void start(String browser){
        temporaryLog("init the ["+browser+"]");
        switch(browser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
                driver = new ChromeDriver(); break;
            case FIREFOX:
                driver = new FirefoxDriver(); break;
            case IE:
                driver = new InternetExplorerDriver(); break;
            case EDGE:
                System.setProperty("webdriver.edge.driver","C:\\Tools\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver(); break;
            default:
                System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
                driver = new ChromeDriver();
        }


        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    public void stop(){
        System.out.println("stopping the ChromeDriver");
        driver.quit();
        driver = null;
    }

    protected void loginAs(String login, String password){
        temporaryLog("logging as user ["+login+"] with password ["+password+"]");
        fill(LOGIN_FIELD,login);
        fill(PSW_FIELD,password);
        click(LOGIN_BTN);
    }

    protected boolean isElementPresent(By locator){
        boolean result = driver.findElements(locator).size()>0;
        if(result){
            temporaryLog("the element ["+locator+"] exists on current page");
        }else{
            temporaryLog("the element ["+locator+"] doesn't exist on current page");
        }
        return result;
    }

    protected void navigateTo(String url){
        temporaryLog("going to ["+url+"]");
        driver.get(url);
    }

    protected void click(By locator){
        temporaryLog("clicking element ["+locator+"]");
        driver.findElement(locator).click();
    }

    protected void click(WebElement element){
        temporaryLog("clicking the element found by ["+extractSelector(element)+"]");
        element.click();
    }

    protected void fill(By fieldLocator, String value){
        WebElement field = driver.findElement(fieldLocator);
        fill(field, value);
    }

    protected void fill(WebElement field, String text){
        temporaryLog("filling the field ["+extractSelector(field)+"] with text ["+text+"]");
        field.clear();
        field.sendKeys(text);
    }

    private String extractSelector(WebElement element){
        return element.toString().split("->")[1];
    }

    protected void temporaryLog(String logMsg){
        System.out.println(logMsg);
    }

    protected void waitForTitle(String title){
        temporaryLog("waiting for title ["+title+"]");
        wait.until(titleIs(title));
    }

    protected void waitForAppearanceOf(By element){
        temporaryLog("waiting for element ["+element+"]");
        wait.until(visibilityOfElementLocated(element));
    }

    public void waitForTextToBe(By locator, String text){
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void waitForDisappearance(WebElement element){
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void selectRandomOptionFromTheDropDown(WebElement dropDown){
        try{
            List<WebElement> options = dropDown.findElements(By.xpath("/.//option"));
            int index = new Random().nextInt(options.size());
            String option = options.get(index).getText();
            while(option.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
                index = new Random().nextInt(options.size());
                option = options.get(index).getText();
            }
            new Select(dropDown).selectByVisibleText(option);
        } catch (NoSuchElementException ex){
            temporaryLog("the drop down doesn't exists on current page");
        }
    }

    public LoginPage onLoginPage(){
        if(loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public MainPage onMainPage(){
        if(mainPage == null){
            mainPage = new MainPage(driver);
        }
        return mainPage;
    }

    public ProductPage onProductPage(){
        if(productPage == null){
            productPage = new ProductPage(driver);
        }
        return productPage;
    }

    public Header onHeader(){
        if(header == null){
            header = new Header(driver);
        }
        return header;
    }

    public Cart onCartPage(){
        if(cart == null){
            cart = new Cart(driver);
        }
        return cart;
    }

    public Navigation navigateTo(){
        if(navigation == null){
            navigation = new Navigation(driver);
        }
        return navigation;
    }

}
