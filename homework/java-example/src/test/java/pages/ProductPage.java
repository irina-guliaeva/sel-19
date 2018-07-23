package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.TimeoutException;

public class ProductPage extends Base {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,3);
        PageFactory.initElements(driver, this);
}

    @FindBy(xpath = "//select[@name='options[Size]']")
    private WebElement selectSizeDropDown;

    @FindBy(css = "button[name=add_cart_product]")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//select[@name='options[Size]']/.//option")
    private List<WebElement> sizeOptions;

    public ProductPage selectDuckSize(){
        try{
            wait.until(ExpectedConditions.visibilityOf(selectSizeDropDown));
        } catch (TimeoutException timeOut){
            temporaryLog("this duck has no size options");
            return this;
        }
        selectRandomOptionFromTheDropDown(selectSizeDropDown);
        return this;
    }

    public ProductPage addDuck2Cart(){
        click(addToCartBtn);
        return this;
    }


}

