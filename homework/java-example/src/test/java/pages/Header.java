package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends Base {

    WebDriver driver;
    private static final String AMOUNT_OF_ITEMS_IN_THE_CART_LOCATOR = "span.quantity";

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = AMOUNT_OF_ITEMS_IN_THE_CART_LOCATOR)
    WebElement amountOfItemsInTheCart;

    @FindBy(xpath="//a[@class = 'link' and text() = 'Checkout »']")
    WebElement checkoutLink;

    public String getAmountOfItemsInTheCart(){
        return amountOfItemsInTheCart.getText();
    }

    public void clickCheckout(){
        click(checkoutLink);
    }

    public By amountOfItemsInTheCart(){
        return By.cssSelector(AMOUNT_OF_ITEMS_IN_THE_CART_LOCATOR);
    }


}
