package tasks;

import helpers.IPageElements;
import helpers.Litecart;
import helpers.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Задание 12
 * Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке). *
 * Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить. *
 * Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять. *
 * Переключение между вкладками происходит не мгновенно, поэтому после переключения можно сделать небольшую паузу (о том, как делать более правильные ожидания, будет рассказано в следующих занятиях). *
 * Картинку с изображением товара нужно уложить в репозиторий вместе с кодом. При этом указывать в коде полный абсолютный путь к файлу плохо, на другой машине работать не будет. Надо средствами языка программирования преобразовать относительный путь в абсолютный. *
 * После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.
 */

public class Task12_AddNewProduct extends Base implements IPageElements {
    @Before
    public void runBrowser(){
        start();
    }

    @Test
    public void addNewProduct(){

        Product newDuck = new Product();
        newDuck
                .setEnabled()
                .setRandomCode()
                .setRandomName()
                .setRandomProductGroup()
                .setRandomQuantity()
                .setValidFromToday()
                .setRandomValidTo()
                .setRandomKeywords()
                .setRandomShortDescription()
                .setRandomDescription()
                .setRandomHeadTitle()
                .setRandomMetaDescription()
                .setRandomPrice()
                .setRandomCurrency();

        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        click(MAIN_MENU_LINK_CATALOG);
        click(BTN_ADD_NEW_PRODUCT);
        chooseProductStatus(newDuck);
        fill(FIELD_PRODUCT_CODE, newDuck.getCode());
        fill(FIELD_PRODUCT_NAME, newDuck.getName());
        markProductGroup(newDuck);
        fill(FIELD_QUANTITY, newDuck.getQuantity()+"");

        newDuck
                .setUnit(getRandomUnits())
                .setDeliveryStatus(getRandomDeliveryStatus())
                .setSoldOutStatus(getRandomSoldOutStatus());

        Select unitsSelection = new Select(driver.findElement(DROP_DOWN_UNITS));
        Select deliveryStatusSelection = new Select(driver.findElement(DROP_DOWN_DELIVERY_STATUS));
        Select soldOutStatusSelection = new Select(driver.findElement(DROP_DOWN_SOLD_OUT_STATUS));

        unitsSelection.selectByVisibleText(newDuck.getUnit());
        deliveryStatusSelection.selectByVisibleText(newDuck.getDeliveryStatus());
        soldOutStatusSelection.selectByVisibleText(newDuck.getSoldOutStatus());

        File image = new File("src/test/resources/duck.jpg");

        uploadImage(image.getAbsolutePath());
        pickDateValidFrom(newDuck.getValidFrom());
        pickDateValidTo(newDuck.getValidTo());

        click(TAB_INFORMATION);

        newDuck.setManufacturer(getRandomManufacturer());
        Select manufacturerSelection = new Select(driver.findElement(DROP_DOWN_MANUFACTURER));
        manufacturerSelection.selectByVisibleText(newDuck.getManufacturer());
//        newDuck.setSupplier(getRandomSupplier());
//        Select supplierSelection = new Select(driver.findElement(DROP_DOWN_SUPPLIER));
//        supplierSelection.selectByVisibleText(newDuck.getSupplier());

        fill(FIELD_KEYWORDS, newDuck.getKeyWords().toString());
        fill(FIELD_SHORT_DESCRIPTION, newDuck.getShortDescription());
        fill(FIELD_DECRIPTION, newDuck.getDescription());
        fill(FIELD_HEAD_TITLE, newDuck.getHeadTitle());
        fill(FIELD_META_DECRIPTION, newDuck.getMetaDescription());

        click(TAB_PRICES);

        fill(FIELD_PURCHASE_PRICES, newDuck.getPrice());

        Select currencySelection = new Select(driver.findElement(DROP_DOWN_CURRENCY));
        currencySelection.selectByVisibleText(newDuck.getCurrency());

        fill(FIELD_PRICES_EUR, getRealPriceEur(newDuck));
        fill(FIELD_PRICES_USD, getRealPriceUsd(newDuck));

        click(BTN_SAVE);

        assertTrue(isElementPresent(newEntry(newDuck)));

    }


    @After
    public void stopBrowser(){
        stop();
    }

    //Add New Product
    public static final By BTN_ADD_NEW_PRODUCT = By.xpath("//a[@class='button' and text() = ' Add New Product']");
    public static final By TAB_GENERAL = By.cssSelector("div.tabs li:nth-child(1)");
    public static final By TAB_INFORMATION = By.cssSelector("div.tabs li:nth-child(2)");
    public static final By TAB_PRICES = By.cssSelector("div.tabs li:nth-child(4)");
    public static final By RADIO_BTN_ENABLED = By.xpath("//input[@type='radio' and @value = '1']");
    public static final By RADIO_BTN_DISABLED = By.xpath("//input[@type='radio' and @value = '0']");
    public static final By FIELD_PRODUCT_NAME = By.xpath("//input[contains(@name,'name')]");
    public static final By FIELD_PRODUCT_CODE = By.cssSelector("input[name = code]");
    public static final By CHECKBOX_FEMALE = By.xpath("//input[@type = 'checkbox' and @value = '1-2']");
    public static final By CHECKBOX_MALE = By.xpath("//input[@type = 'checkbox' and @value = '1-1']");
    public static final By CHECKBOX_UNISEX = By.xpath("//input[@type = 'checkbox' and @value = '1-3']");
    public static final By FIELD_QUANTITY = By.cssSelector("input[name=quantity]");
    public static final By DROP_DOWN_UNITS = By.cssSelector("select[name=quantity_unit_id]");
    public static final By UNITS_OPTIONS = By.cssSelector("select[name=quantity_unit_id] option");
    public static final By DROP_DOWN_DELIVERY_STATUS =By.cssSelector("select[name=delivery_status_id]");
    public static final By DELIVERY_STATUS_OPTIONS =By.cssSelector("select[name=delivery_status_id] option");
    public static final By DROP_DOWN_SOLD_OUT_STATUS =By.cssSelector("select[name=sold_out_status_id]");
    public static final By SOLD_OUT_STATUS_OPTIONS =By.cssSelector("select[name=sold_out_status_id] option");
    public static final By UPLOAD_IMAGE = By.cssSelector("input[type=file]");
    public static final By START_DATE = By.cssSelector("input[name=date_valid_from]");
    public static final By END_DATE = By.cssSelector("input[name=date_valid_to]");
    public static final By DROP_DOWN_MANUFACTURER = By.cssSelector("select[name=manufacturer_id]");
    public static final By MANUFACTURER_OPTIONS = By.cssSelector("select[name=manufacturer_id] option");
    public static final By DROP_DOWN_SUPPLIER = By.cssSelector("select[name=supplier_id]");
    public static final By SUPPLIER_OPTIONS = By.cssSelector("select[name=supplier_id] option");
    public static final By FIELD_KEYWORDS = By.cssSelector("input[name=keywords]");
    public static final By FIELD_SHORT_DESCRIPTION =  By.xpath("//input[contains(@name,'short_description')]");
    public static final By FIELD_DECRIPTION = By.cssSelector("div.trumbowyg-editor");
    public static final By FIELD_HEAD_TITLE =  By.xpath("//input[contains(@name,'head_title')]");
    public static final By FIELD_META_DECRIPTION = By.xpath("//input[contains(@name,'meta_description')]");
    public static final By FIELD_PURCHASE_PRICES = By.cssSelector("input[name=purchase_price]");
    public static final By DROP_DOWN_CURRENCY = By.cssSelector("select[name=purchase_price_currency_code]");
    public static final By DROP_DOWN_TAX =By.cssSelector("select[name=tax_class_id]");
    public static final By FIELD_PRICES_USD = By.xpath("//input[@name = 'prices[USD]']");
    public static final By FIELD_PRICES_EUR = By.xpath("//input[@name = 'prices[EUR]']");
    public static final By BTN_SAVE = By.cssSelector("button[name=save]");
    public static final String PATH_TO_NEW_ENTRY = "//a[text()='%']";

    private Random rnd = new Random();
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("#.##");


    public void chooseProductStatus(Product product){
        if(product.isEnabled()){
            click(RADIO_BTN_ENABLED);
        } else{
            click(RADIO_BTN_DISABLED);
        }
    }

    public void markProductGroup (Product product){
        switch(product.getProductGroup()){
            case Litecart.PRODUCT_GROUP_FEMALE: click(CHECKBOX_FEMALE); break;
            case Litecart.PRODUCT_GROUP_MALE: click(CHECKBOX_MALE); break;
            case Litecart.PRODUCT_GROUP_UNISEX: click(CHECKBOX_UNISEX); break;
            default: click(CHECKBOX_UNISEX); break;
        }
    }

    public String getRandomUnits(){
        List<WebElement> options = driver.findElements(UNITS_OPTIONS);
        int index = rnd.nextInt(options.size());
        String unit = options.get(index).getText();
        while(unit.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
            index = rnd.nextInt(options.size());
            unit = options.get(index).getText();
        }
        return unit;
    }

    public String getRandomDeliveryStatus(){
        List<WebElement> options = driver.findElements(DELIVERY_STATUS_OPTIONS);
        int index = rnd.nextInt(options.size());
        String deliveryStatus = options.get(index).getText();
        while(deliveryStatus.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
            index = rnd.nextInt(options.size());
            deliveryStatus = options.get(index).getText();
        }
        return deliveryStatus;
    }

    public String getRandomSoldOutStatus(){
        List<WebElement> options = driver.findElements(SOLD_OUT_STATUS_OPTIONS);
        int index = rnd.nextInt(options.size());
        String soldOutStatus = options.get(index).getText();
        return soldOutStatus;
    }

    public void uploadImage(String path) {
        WebElement upload = driver.findElement(UPLOAD_IMAGE);
        upload.sendKeys(path);
    }

    public void pickDateValidFrom(Calendar start){
        String date = format.format(start.getTime());
        WebElement startDate = driver.findElement(START_DATE);
        startDate.sendKeys(date);
    }

    public void pickDateValidTo(Calendar end){
        String date = format.format(end.getTime());
        WebElement endDate = driver.findElement(END_DATE);
        endDate.sendKeys(date);
    }

    public String getRandomManufacturer(){
        List<WebElement> options = driver.findElements(MANUFACTURER_OPTIONS);
        int index = rnd.nextInt(options.size());
        String manufacturer = options.get(index).getText();
        while(manufacturer.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
            index = rnd.nextInt(options.size());
            manufacturer = options.get(index).getText();
        }
        return manufacturer;
    }

    public String getRandomSupplier(){
        List<WebElement> options = driver.findElements(SUPPLIER_OPTIONS);
        int index = rnd.nextInt(options.size());
        String manufacturer = options.get(index).getText();
        while(manufacturer.equals(Litecart.OPTION_NEEDS_TO_BE_SELECTED)){
            index = rnd.nextInt(options.size());
            manufacturer = options.get(index).getText();
        }
        return manufacturer;
    }

    public String getRealPriceEur(Product product){
        double realPrice = 0.0;
        if(product.getCurrency().equals(Litecart.CURRENCY_EUR)){
            realPrice = Double.parseDouble(product.getPrice())-(Double.parseDouble(product.getPrice())*0.3);
        } else {
            realPrice = Double.parseDouble(product.getPrice())*0.85;
            realPrice = realPrice-(realPrice*0.3);
        }

        return df(realPrice);
    }

    public String getRealPriceUsd(Product product){
        double realPrice = 0.0;
        if(product.getCurrency().equals(Litecart.CURRENCY_USD)){
            realPrice = Double.parseDouble(product.getPrice())-(Double.parseDouble(product.getPrice())*0.3);
        } else {
            realPrice = Double.parseDouble(product.getPrice())*1.17;
            realPrice = realPrice-(realPrice*0.3);
        }

        return df(realPrice);
    }

    private String df(double d){
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
        dfs.setDecimalSeparator('.');
        String pattern = "#.##";
        DecimalFormat format = new DecimalFormat(pattern, dfs);
        return format.format(d);
    }

    private By newEntry(Product product){
        String[] link = PATH_TO_NEW_ENTRY.split("%");
        return By.xpath(link[0]+product.getName()+link[1]);
    }


}
