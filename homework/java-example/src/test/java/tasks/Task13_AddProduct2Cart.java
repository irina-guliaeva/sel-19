package tasks;

import helpers.Litecart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.Base;

import java.util.List;

import static helpers.RandomHelper.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Сделайте сценарий для добавления товаров в корзину и удаления товаров из корзины.
 *
 * 1) открыть главную страницу
 * 2) открыть первый товар из списка
 * 2) добавить его в корзину (при этом может случайно добавиться товар, который там уже есть, ничего страшного)
 * 3) подождать, пока счётчик товаров в корзине обновится
 * 4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
 * 5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
 * 6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
 */

public class Task13_AddProduct2Cart extends Base {


    private static final By DUCKS = By.cssSelector("li.product");
    private static final By ADD_TO_CART = By.cssSelector("button[name=add_cart_product]");
    private static final By DROP_DOWN_SELECT_SIZE = By.xpath("//select[@name='options[Size]']");
    private static final By SIZE_OPTIONS = By.xpath("//select[@name='options[Size]']/.//option");
    private static final By DIFFERENT_ITEMS_IN_THE_CART =  By.cssSelector("td.item");
    private static final By NUMBER_OF_ITEMS_IN_THE_CART = By.cssSelector("span.quantity");
    private static final By BTN_REMOVE = By.cssSelector("button[name=remove_cart_item]");

    private static final int AMOUNT_OF_BOUGHT_DUCKS = 3;
    private static final By LINK_CHECKOUT = By.xpath("//a[@class = 'link' and text() = 'Checkout »']");
    private static final By LINK_BACK = By.xpath("//a[text() = '<< Back']");
    public static final By ORDER_SUMMARY = By.cssSelector("div#box-checkout-summary");
    public static final By FIRST_SHORTCUT = By.cssSelector("li.shortcut:first-child");
    public static final By FIRST_PRODUCT_IN_TABLE = By.cssSelector("div#box-checkout-summary tr:nth-child(2)");


    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void addProduct2Cart() {
        int numberOfProducts = AMOUNT_OF_BOUGHT_DUCKS;//rnd.nextInt(20);
        WebElement quantity = null;
        for(int i = 0; i <numberOfProducts; i++){
            //идем на главную страницу
            navigateTo(LITECART_MAIN);
            //находим всех уток, которые предлагаются
            List<WebElement> ducks = driver.findElements(DUCKS);
            //выбираем первую из них
            WebElement firstDuck = ducks.get(0);
            //кликаем на первую утку
            firstDuck.click();
            //узнаем сколько уток в корзине сейчас
            quantity = driver.findElement(NUMBER_OF_ITEMS_IN_THE_CART);
            //сообщаем об этом
            temporaryLog("number of items in the cart = "+ quantity.getText());
            //если надо, то выбираем размер утки
            selectRandomSize();
            //добавляем утку в корзину
            click(ADD_TO_CART);
            //ждем, пока количество уток в корзине увеличится на 1
            wait.until(ExpectedConditions.textToBe(NUMBER_OF_ITEMS_IN_THE_CART,Integer.parseInt(quantity.getText())+1+""));
        }

        //если корзина не пустая
        if(Integer.parseInt(quantity.getText())>0){
            //убеждаемся в том, что добавлено столько, сколько планировали
            assertEquals(numberOfProducts+"", quantity.getText());
            //сообщаем о намерянии идти в корзину
            temporaryLog("going to cart");
            //идем в корзину
            click(LINK_CHECKOUT);

            //проверяем сколько разных видов уточек находится в корзине
            int amountOfDifferentItems = driver.findElements(DIFFERENT_ITEMS_IN_THE_CART).size();
            //пока не закончится количество продуктов в корзине
            for(int i =0; i < amountOfDifferentItems; i++){
                //проверяем сколько разных видов уточек находится в корзине
                List<WebElement>  differentItems = driver.findElements(DIFFERENT_ITEMS_IN_THE_CART);
                //находим все кнопки на удаления
                List<WebElement> removeBtns = driver.findElements(BTN_REMOVE);
                switch(differentItems.size()){
                case 0: temporaryLog("cart is empty"); break;
                case 1: //если вид уточки только 1
                        temporaryLog("there is only one type of product in the cart");
                        //находим таблицу со списком покупок
                        WebElement orderSummary = driver.findElement(ORDER_SUMMARY);
                        //нажимаем кнопку удаления
                        removeBtns.get(0).click();
                        //ждем пока вся таблица исчезнет, потому что в корзине теперь должго быть пусто
                        wait.until(ExpectedConditions.stalenessOf(orderSummary)); break;
                default: //если в корзине несколько разных видов уточек
                        temporaryLog("there is ["+differentItems.size()+"] different types of product in the cart");
                        //то мы жмем по превью первой уточки
                        click(FIRST_SHORTCUT);
                        //ждем, пока появится кнопка, соответствующая первой уточке
                        wait.until(ExpectedConditions.visibilityOf(removeBtns.get(0)));
                        //находим в таблице строчку, содержащую информацию о первом продукте
                        WebElement firstProduct = driver.findElement(FIRST_PRODUCT_IN_TABLE);
                        //жмем кнопку удалить
                        removeBtns.get(0).click();
                        //ждем, пока строчка с первым продуктом исчезнет
                        wait.until(ExpectedConditions.stalenessOf(firstProduct));
                }
                differentItems = driver.findElements(DIFFERENT_ITEMS_IN_THE_CART);
            }
        }
        //после того как корзина опустела, жмем ссылку назад
        click(LINK_BACK);
        //смотрим сколько осталось в корзине уток
        quantity = driver.findElement(NUMBER_OF_ITEMS_IN_THE_CART);
        //убеждаемся, что ни одной утки не осталось
        assertEquals("0",quantity.getText());
   }


    @After
    public void stopBrowser(){
        stop();
    }

    private void selectRandomSize(){
        if(isElementPresent(DROP_DOWN_SELECT_SIZE)){ ;
            List<WebElement> options = driver.findElements(SIZE_OPTIONS);
            int index = rnd.nextInt(options.size());
            String size = options.get(index).getText();
            while(size.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
                index = rnd.nextInt(options.size());
                size = options.get(index).getText();
            }
            Select sizeSelection = new Select(driver.findElement(DROP_DOWN_SELECT_SIZE));
            sizeSelection.selectByVisibleText(size);
        }
    }


}
