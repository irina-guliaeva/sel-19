import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Base {

    public Base(){

    }

    WebDriver driver;
    WebDriverWait wait;

    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        System.out.println("init the ChromeDriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    public void stop(){
        System.out.println("stopping the ChromeDriver");
        driver.quit();
        driver = null;
    }

    protected void navigateTo(String url){
        temporaryLog("going to ["+url+"]");
        driver.get(url);
    }

    protected void fill(By fieldLocator, String value){
        temporaryLog("filling the field ["+fieldLocator+"] with value ["+value+"]");
        WebElement field = driver.findElement(fieldLocator);
        field.clear();
        field.sendKeys(value);
    }

    protected void clickBtn(By btnLocator){
        temporaryLog("clicking the button ["+btnLocator+"]");
        WebElement btn = driver.findElement(btnLocator);
        btn.click();
    }

    protected void waitForTitle(String title){
        temporaryLog("waiting for title ["+title+"]");
        wait.until(titleIs(title));
    }

    protected void waitForAppearanceOf(By element){
        temporaryLog("waiting for element ["+element+"]");
        wait.until(visibilityOfElementLocated(element));
    }

    protected void temporaryLog(String logMsg){
        System.out.println(logMsg);
    }

}
