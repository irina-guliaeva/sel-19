package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Задание 19
 * Переделайте созданный в задании 13 сценарий для добавления товаров в корзину и удаления товаров из корзины,
 * чтобы он использовал многослойную архитектуру. *
 * А именно, выделите вспомогательные классы для работы с главной страницей (откуда выбирается товар),
 * для работы со страницей товара (откуда происходит добавление товара в корзину),
 * со страницей корзины (откуда происходит удаление),
 * и реализуйте сценарий, который не напрямую обращается к операциям Selenium,
 * а оперирует вышеперечисленными объектами-страницами.
 */

public class Task19_MultilayeredArchitecture extends Base {

    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void addDuckToCart(){
        int requiredNumberOfDucks = 3;//new Random().nextInt(20);

        for(int i = 0; i< requiredNumberOfDucks; i++){
            navigateTo().litecartApp();
            onMainPage().clickFirstDuck();
            String amountOfItemsInTheCart = onHeader().getAmountOfItemsInTheCart();
            onProductPage()
                    .selectDuckSize()
                    .addDuck2Cart();
            String expectedAmount = Integer.parseInt(amountOfItemsInTheCart)+1+"";
            waitForTextToBe(onHeader().amountOfItemsInTheCart(), expectedAmount);
        }

        onHeader().clickCheckout();

        int diffItems = onCartPage().getAmountOfDifferentItems();

        for(int i = 0; i< diffItems; i++){
            if(onCartPage().isThereOneTypeOfItems()){
                WebElement orderSummary = onCartPage().getOrderSummaryTable();
                onCartPage().clickRemoveFirstItem();
                wait.until(ExpectedConditions.stalenessOf(orderSummary));
               // waitForDisappearance(orderSummary);
            }else{
                WebElement firstDuck = onCartPage().getFirstProduct();
                onCartPage()
                        .clickFirstShortcut()
                        .clickRemoveFirstItem();
                waitForDisappearance(firstDuck);
            }
        }
        onCartPage().clickLinkBack();
        assertEquals(0+"", onHeader().getAmountOfItemsInTheCart());
    }

    @After
    public void stopBrowser(){
        stop();
    }
}
