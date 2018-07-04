import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task7_GoTroughMainMenu extends Base implements IPageElements{

    /**
     * Cделайте сценарий, который выполняет следующие действия в учебном приложении litecart.     *
     * 1) входит в панель администратора http://localhost/litecart/admin
     * 2) прокликивает последовательно все пункты меню слева, включая вложенные пункты
     * 3) для каждой страницы проверяет наличие заголовка (то есть элемента с тегом h1)
     * Можно оформить сценарий либо как тест, либо как отдельный исполняемый файл.
     */

    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkSections(){

        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);

        click(MAIN_MENU_LINK_APPEARENCE);
        click(SUB_MENU_APPEARENCE_LINK_TEMPLATE);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_APPEARENCE_LINK_LOGOTYPE);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_CATALOG);
        click(SUB_MENU_CATALOG_LINK_CATALOG);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_PRODUCT_GROUPS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_OPTION_GROUPS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_MANUFACTURERS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_SUPPLIERS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_DELIVERY_STATUSES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_SOLD_OUT_STATUSES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_DOC_QUANTITY_UNITS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CATALOG_LINK_CSV);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_COUNTRIES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_CURRENCIES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_CUSTOMERS);
        click(SUB_MENU_CUSTOMERS_LINK_CUSTOMERS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CUSTOMERS_LINK_CSV);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_CUSTOMERS_LINK_NEWSLETTER);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_GEO_ZONES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_LANGUAGES);
        click(SUB_MENU_LANGUAGES_LINK_LANGUAGES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_LANGUAGES_LINK_STORAGE_ENCODING);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_MODULES);
        click(SUB_MENU_MODULES_LINK_BACKGROUND_JOBS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_CUSTOMER);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_SHIPPING);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_PAYMENT);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_ORDER_TOTAL);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_ORDER_SUCCESS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_MODULES_LINK_ORDER_ACTION);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_ORDERS);
        click(SUB_MENU_ORDERS_LINK_ORDER_ORDERS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_ORDERS_LINK_ORDER_ORDERS_STATUSES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_PAGES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_REPORTS);
        click(SUB_MENU_REPORTS_LINK_ORDER_MONTHLY_SALES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_REPORTS_LINK_ORDER_MOST_SOLD_PRODUCTS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_REPORTS_LINK_ORDER_MOST_SHOPPING_CUSTOMERS);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_SETTINGS);
        click(SUB_MENU_SETTINGS_LINK_STORE_INFO);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_DEFAULTS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_GENERAL);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_LISTINGS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_IMAGES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_CHECKOUT);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_ADVANCED);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_SETTINGS_LINK_SECURITY);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_SLIDES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_TAX);
        click(SUB_MENU_TAX_LINK_TAX_CLASSES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_TAX_LINK_TAX_RATES);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_TRANSLATIONS);
        click(SUB_MENU_TRANSLATIONS_LINK_SEARCH_TRANSTALIONS);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_TRANSLATIONS_LINK_SCAN_FILES);
        assertTrue(isElementPresent(PAGE_TITLE));
        click(SUB_MENU_TRANSLATIONS_LINK_CSV);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_USERS);
        assertTrue(isElementPresent(PAGE_TITLE));

        click(MAIN_MENU_LINK_VQMODS);
        assertTrue(isElementPresent(PAGE_TITLE));






    }


    @After
    public void stopBrowser(){
        stop();
    }

}
