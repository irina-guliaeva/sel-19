import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.junit.Assert.*;

public class Task8_CheckStickers extends Base{

    /**
     * Задание 8
     * Сделайте сценарий, проверяющий наличие стикеров у всех товаров в учебном приложении litecart на главной странице.
     * Стикеры -- это полоски в левом верхнем углу изображения товара, на которых написано New или Sale или что-нибудь другое.
     * Сценарий должен проверять, что у каждого товара имеется ровно один стикер.
     */


    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkStickers(){
        navigateTo("http://localhost/litecart");
        List<WebElement> goods = driver.findElements(By.cssSelector("#img.image"));
        for(WebElement good : goods){
            WebElement sticker = good.findElement(By.cssSelector("#div.sticker new"));
        }


    }

    @After
    public void stopBrowser(){
        stop();
    }
}
