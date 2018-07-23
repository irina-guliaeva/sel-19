package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Cart extends Base {

    WebDriver driver;
    WebDriverWait wait;

    public Cart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,3);
        PageFactory.initElements(driver, this);
    }

    private By ORDER_SUMMARY_TABLE = By.cssSelector("div#box-checkout-summary");

    @FindBy(css = "td.item")
    List<WebElement> differentItemsInTheCart;

    @FindBy(css = "div#box-checkout-summary")
    WebElement orderSummaryTable;

    @FindBy(css = "button[name=remove_cart_item]")
    List<WebElement> removeBnts;

    @FindBy(xpath = "//a[text() = '<< Back']")
    WebElement backLink;

    @FindBy(css = "li.shortcut")
    List<WebElement> shortcuts;

    public int getAmountOfDifferentItems(){
        return differentItemsInTheCart.size();
    }

    public boolean isThereOneTypeOfItems(){
        return differentItemsInTheCart.size() == 1;
    }

    public void clickRemoveFirstItem(){
        clickRemoveItemNumber(1);
    }

    public void clickRemoveItemNumber(int number){
        wait.until(ExpectedConditions.visibilityOf(removeBnts.get(number-1)));
        click(removeBnts.get(number-1));
    }

    public Cart clickFirstShortcut(){
        clickShorcutNumber(1);
        return this;
    }

    public Cart clickShorcutNumber(int number){
        click(shortcuts.get(number-1));
        return this;
    }

    public Cart clickLinkBack(){
        click(backLink);
        return this;
    }


    public WebElement getFirstProduct(){
        return differentItemsInTheCart.get(0);
    }

    public WebElement getOrderSummaryTable() {
        return driver.findElement(ORDER_SUMMARY_TABLE);
    }
}
