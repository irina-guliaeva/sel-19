package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Base {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li.product")
    List<WebElement> ducks;

    public void clickDuckNumber(int index){
        click(ducks.get(index-1));
    }

    public void clickFirstDuck(){
        clickDuckNumber(1);
    }


}
