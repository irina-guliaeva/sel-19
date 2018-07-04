import org.openqa.selenium.By;

public interface IPageElements {

    By PAGE_TITLE = By.cssSelector("h1");

    By MAIN_MENU_LINK_APPEARENCE = By.linkText("Appearence");
    By MAIN_MENU_LINK_CATALOG = By.linkText("Catalog");
    By MAIN_MENU_LINK_COUNTRIES = By.linkText("Countries");
    By MAIN_MENU_LINK_CURRENCIES = By.linkText("Currencies");
    By MAIN_MENU_LINK_CUSTOMERS = By.linkText("Customers");
    By MAIN_MENU_LINK_GEO_ZONES = By.linkText("Geo Zones");
    By MAIN_MENU_LINK_LANGUAGES = By.linkText("Languages");
    By MAIN_MENU_LINK_MODULES = By.linkText("Modules");
    By MAIN_MENU_LINK_ORDERS = By.linkText("Orders");
    By MAIN_MENU_LINK_PAGES = By.linkText("Pages");
    By MAIN_MENU_LINK_REPORTS = By.linkText("Reports");
    By MAIN_MENU_LINK_SETTINGS = By.linkText("Settings");
    By MAIN_MENU_LINK_SLIDES = By.linkText("Slides");
    By MAIN_MENU_LINK_TAX = By.linkText("Tax");
    By MAIN_MENU_LINK_TRANSLATIONS = By.linkText("Translations");
    By MAIN_MENU_LINK_USERS = By.linkText("Users");
    By MAIN_MENU_LINK_VQMODS = By.linkText("vQmods");

    //Appearence
    By SUB_MENU_APPEARENCE_LINK_TEMPLATE = By.cssSelector("div#box-apps-menu-wrapper li#doc-template");
    By SUB_MENU_APPEARENCE_LINK_LOGOTYPE = By.cssSelector("div#box-apps-menu-wrapper li#doc-logotype");
    //Catelog
    By SUB_MENU_CATALOG_LINK_CATALOG = By.cssSelector("div#box-apps-menu-wrapper li#doc-catalog");
    By SUB_MENU_CATALOG_LINK_PRODUCT_GROUPS = By.cssSelector("div#box-apps-menu-wrapper li#doc-product_groups");
    By SUB_MENU_CATALOG_LINK_OPTION_GROUPS = By.cssSelector("div#box-apps-menu-wrapper li#doc-option_groups");
    By SUB_MENU_CATALOG_LINK_MANUFACTURERS = By.cssSelector("div#box-apps-menu-wrapper li#doc-manufacturers");
    By SUB_MENU_CATALOG_LINK_SUPPLIERS = By.cssSelector("div#box-apps-menu-wrapper li#doc-suppliers");
    By SUB_MENU_CATALOG_LINK_DELIVERY_STATUSES = By.cssSelector("div#box-apps-menu-wrapper li#doc-delivery_statuses");
    By SUB_MENU_CATALOG_LINK_SOLD_OUT_STATUSES = By.cssSelector("div#box-apps-menu-wrapper li#doc-sold_out_statuses");
    By SUB_MENU_CATALOG_LINK_DOC_QUANTITY_UNITS= By.cssSelector("div#box-apps-menu-wrapper li#doc-quantity_units");
    By SUB_MENU_CATALOG_LINK_CSV = By.cssSelector("div#box-apps-menu-wrapper li#doc-csv");
    //Customers
    By SUB_MENU_CUSTOMERS_LINK_CUSTOMERS = By.cssSelector("div#box-apps-menu-wrapper li#doc-customers");
    By SUB_MENU_CUSTOMERS_LINK_CSV = By.cssSelector("div#box-apps-menu-wrapper li#doc-csv");
    By SUB_MENU_CUSTOMERS_LINK_NEWSLETTER = By.cssSelector("div#box-apps-menu-wrapper li#doc-newsletter");
    //Languages
    By SUB_MENU_LANGUAGES_LINK_LANGUAGES = By.cssSelector("div#box-apps-menu-wrapper li#doc-languages");
    By SUB_MENU_LANGUAGES_LINK_STORAGE_ENCODING = By.cssSelector("div#box-apps-menu-wrapper li#doc-storage_encoding");
    //Modules
    By SUB_MENU_MODULES_LINK_BACKGROUND_JOBS = By.cssSelector("div#box-apps-menu-wrapper li#doc-jobs");
    By SUB_MENU_MODULES_LINK_CUSTOMER = By.cssSelector("div#box-apps-menu-wrapper li#doc-customer");
    By SUB_MENU_MODULES_LINK_SHIPPING = By.cssSelector("div#box-apps-menu-wrapper li#doc-shipping");
    By SUB_MENU_MODULES_LINK_PAYMENT = By.cssSelector("div#box-apps-menu-wrapper li#doc-payment");
    By SUB_MENU_MODULES_LINK_ORDER_TOTAL = By.cssSelector("div#box-apps-menu-wrapper li#doc-order_total");
    By SUB_MENU_MODULES_LINK_ORDER_SUCCESS = By.cssSelector("div#box-apps-menu-wrapper li#doc-order_success");
    By SUB_MENU_MODULES_LINK_ORDER_ACTION = By.cssSelector("div#box-apps-menu-wrapper li#doc-order_action");
    //Orders
    By SUB_MENU_ORDERS_LINK_ORDER_ORDERS = By.cssSelector("div#box-apps-menu-wrapper li#doc-orders");
    By SUB_MENU_ORDERS_LINK_ORDER_ORDERS_STATUSES = By.cssSelector("div#box-apps-menu-wrapper li#doc-order_statuses");
    //Reports
    By SUB_MENU_REPORTS_LINK_ORDER_MONTHLY_SALES = By.cssSelector("div#box-apps-menu-wrapper li#doc-monthly_sales");
    By SUB_MENU_REPORTS_LINK_ORDER_MOST_SOLD_PRODUCTS = By.cssSelector("div#box-apps-menu-wrapper li#doc-most_sold_products");
    By SUB_MENU_REPORTS_LINK_ORDER_MOST_SHOPPING_CUSTOMERS = By.cssSelector("div#box-apps-menu-wrapper li#doc-most_shopping_customers");
    //Settings
    By SUB_MENU_SETTINGS_LINK_STORE_INFO = By.cssSelector("div#box-apps-menu-wrapper li#doc-store_info");
    By SUB_MENU_SETTINGS_LINK_DEFAULTS = By.cssSelector("div#box-apps-menu-wrapper li#doc-defaults");
    By SUB_MENU_SETTINGS_LINK_GENERAL = By.cssSelector("div#box-apps-menu-wrapper li#doc-general");
    By SUB_MENU_SETTINGS_LINK_LISTINGS = By.cssSelector("div#box-apps-menu-wrapper li#doc-listings");
    By SUB_MENU_SETTINGS_LINK_IMAGES = By.cssSelector("div#box-apps-menu-wrapper li#doc-images");
    By SUB_MENU_SETTINGS_LINK_CHECKOUT = By.cssSelector("div#box-apps-menu-wrapper li#doc-checkout");
    By SUB_MENU_SETTINGS_LINK_ADVANCED = By.cssSelector("div#box-apps-menu-wrapper li#doc-advanced");
    By SUB_MENU_SETTINGS_LINK_SECURITY = By.cssSelector("div#box-apps-menu-wrapper li#doc-security");
    //Tax
    By SUB_MENU_TAX_LINK_TAX_CLASSES = By.cssSelector("div#box-apps-menu-wrapper li#doc-tax_classes");
    By SUB_MENU_TAX_LINK_TAX_RATES = By.cssSelector("div#box-apps-menu-wrapper li#doc-tax_rates");
    //Translations
    By SUB_MENU_TRANSLATIONS_LINK_SEARCH_TRANSTALIONS = By.cssSelector("div#box-apps-menu-wrapper li#doc-search");
    By SUB_MENU_TRANSLATIONS_LINK_SCAN_FILES = By.cssSelector("div#box-apps-menu-wrapper li#doc-scan");
    By SUB_MENU_TRANSLATIONS_LINK_CSV = By.cssSelector("div#box-apps-menu-wrapper li#doc-csv");
    //vQmodc
    By SUB_MENU_VQMODS_LINK_VQMODS = By.cssSelector("div#box-apps-menu-wrapper li#doc-vqmods");


}
