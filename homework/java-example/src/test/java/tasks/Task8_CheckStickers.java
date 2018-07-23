package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Base;

import java.util.List;
import static org.junit.Assert.*;

public class Task8_CheckStickers extends Base {

    /**
     * Задание 8
     * Сделайте сценарий, проверяющий наличие стикеров у всех товаров в учебном приложении litecart на главной странице.
     * Стикеры -- это полоски в левом верхнем углу изображения товара, на которых написано New или Sale или что-нибудь другое.
     * Сценарий должен проверять, что у каждого товара имеется ровно один стикер.
     */

    private static final By DUCKS = By.cssSelector("li.product");
    private static final By IMAGE = By.cssSelector("img.image");
    private static final By STICKER = By.xpath(".//div[contains(@class,'sticker')]");

    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkStickers(){
        navigateTo(LITECART_MAIN);
        List<WebElement> goods = driver.findElements(DUCKS);

        for(WebElement good : goods){
            assertEquals(1, good.findElements(STICKER).size());
            WebElement sticker = good.findElement(STICKER);
            temporaryLog("for product ["+good.findElement(IMAGE).getAttribute("alt")+"] the sticker ["+sticker.getText()+"] was found");
        }
    }

    @After
    public void stopBrowser(){
        stop();
    }
}
