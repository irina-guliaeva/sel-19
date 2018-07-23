package pages;

import org.openqa.selenium.WebDriver;

public class Navigation extends Base {

    protected final static String LITECART_ADMIN = "http://localhost/litecart/admin/";
    protected final static String LITECART_APP = "http://localhost/litecart";
    WebDriver driver;


    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public void litecartAdmin(){
        driver.get(LITECART_ADMIN);
    }

    public void litecartApp(){
        driver.get(LITECART_APP);
    }


}
