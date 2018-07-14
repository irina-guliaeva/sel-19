package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class Task10_CheckProduct extends Base{

    /**
     * Сделайте сценарий, который проверяет, что при клике на товар открывается правильная страница товара в учебном приложении litecart.
     *
     * Более точно, нужно открыть главную страницу, выбрать первый товар в блоке Campaigns и проверить следующее:
     *
     * а) на главной странице и на странице товара совпадает текст названия товара
     * б) на главной странице и на странице товара совпадают цены (обычная и акционная)
     * в) обычная цена зачёркнутая и серая (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
     * г) акционная жирная и красная (можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)
     * (цвета надо проверить на каждой странице независимо, при этом цвета на разных страницах могут не совпадать)
     * д) акционная цена крупнее, чем обычная (это тоже надо проверить на каждой странице независимо)
     *
     * Необходимо убедиться, что тесты работают в разных браузерах, желательно проверить во всех трёх ключевых браузерах (Chrome, Firefox, IE).
     */


    private static final By DUCKS = By.cssSelector("a.link");
    private static final By NAME = By.cssSelector("div.name");
    private static final By REGULAR_PRICE = By.cssSelector("div.price-wrapper s.regular-price");
    private static final By CAMPAIGN_PRICE = By.cssSelector("div.price-wrapper strong.campaign-price");

    private static final By BOX_CAMPAGNIES = By.cssSelector("div#box-campaigns div.content");


    @Before
    public void runBrowser(){
        start();
    }

    @Test
    public void checkFirstProduct(){
        navigateTo(LITECART_MAIN);

        WebElement campagnies = driver.findElement(BOX_CAMPAGNIES);
        WebElement duck = campagnies.findElements(DUCKS).get(0);

        String productName = duck.findElement(NAME).getText();
        WebElement regularPrice = duck.findElement(REGULAR_PRICE);
        String regPrice = regularPrice.getText();
        String regularPriceColor = regularPrice.getCssValue("color");
        String regularPriceStyle = regularPrice.getCssValue("text-decoration");
        Dimension regularPriceSize = regularPrice.getSize();

        WebElement campaignPrice = duck.findElement(CAMPAIGN_PRICE);
        String campPrice = campaignPrice.getText();
        String campaignPriceColor = duck.findElement(CAMPAIGN_PRICE).getCssValue("color");
        String campaignPriceStyle = campaignPrice.getCssValue("text-decoration");
        Dimension campaignPriceSize = campaignPrice.getSize();

        temporaryLog("reg Price: "+regPrice);
        temporaryLog("reg Price color: "+regularPriceColor);
        temporaryLog("reg Price style: "+regularPriceStyle);
        temporaryLog("reg Price size: ["+regularPriceSize.getHeight()+"]x["+regularPriceSize.getWidth()+"]");

        temporaryLog("campaign Price: "+campPrice);
        temporaryLog("campaign Price color: "+campaignPriceColor);
        temporaryLog("campaign Price style: "+campaignPriceStyle);
        temporaryLog("campaign Price size: ["+campaignPriceSize.getHeight()+"]x["+campaignPriceSize.getWidth()+"]");

    }



    @After
    public void stopBrowser(){
        stop();
    }
}
