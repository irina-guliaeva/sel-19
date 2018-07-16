package tasks;

import helpers.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;



public class Task11_Registration extends Base{

    /**
     * Сделайте сценарий для регистрации нового пользователя в учебном приложении litecart (не в админке, а в клиентской части магазина).
     *
     * Сценарий должен состоять из следующих частей:
     *
     * 1) регистрация новой учётной записи с достаточно уникальным адресом электронной почты (чтобы не конфликтовало с ранее созданными пользователями, в том числе при предыдущих запусках того же самого сценария),
     * 2) выход (logout), потому что после успешной регистрации автоматически происходит вход,
     * 3) повторный вход в только что созданную учётную запись,
     * 4) и ещё раз выход.
     *
     * В качестве страны выбирайте United States, штат произвольный. При этом формат индекса -- пять цифр.
     */

    private static final By REGISTER_NEW_CUSTOMER = By.cssSelector("form[name = login_form] a");

    private static final By TAX_ID = By.cssSelector("input[name=tax_id]");
    private static final By COMPANY = By.cssSelector("input[name=company]");
    private static final By FIRST_NAME = By.cssSelector("input[name=firstname]");
    private static final By LAST_NAME = By.cssSelector("input[name=lastname]");
    private static final By ADDRESS_1 = By.cssSelector("input[name=address1]");
    private static final By POSTCODE = By.cssSelector("input[name=postcode]");
    private static final By CITY = By.cssSelector("input[name=city]");
    private static final By EMAIL = By.cssSelector("input[name=email]");
    private static final By PHONE = By.cssSelector("input[name=phone]");
    private static final By PASSWORD = By.cssSelector("input[name=password]");
    private static final By CONFIRM_PASSWORD = By.cssSelector("input[name=confirmed_password]");
    private static final By COUNTRY = By.cssSelector("select[name=country_code]");
    private static final By ZONE_STATE_PROVINCE = By.cssSelector("select[name=zone_code]");
    private static final By ZONE_STATE_PROVINCE_OPTIONS = By.cssSelector("select[name=zone_code] option");
    private static final By CREATE_ACCOUNT = By.cssSelector("button[name=create_account]");
    private static final By LOGOUT = By.cssSelector("aside#navigation div#box-account ul.list-vertical li:last-child a");

    private static final By LOGIN = By.cssSelector("form[name = login_form] input[name = email]");
    private static final By PSW = By.cssSelector("form[name = login_form] input[name = password]");
    private static final By LOGIN_BTN = By.cssSelector("button[name=login]");


    @Before
    public void runBrowser(){
        start();
    }

    @Test
    public void registration(){
        User newUser = new User().setRandomData();
        navigateTo(LITECART_MAIN);
        click(REGISTER_NEW_CUSTOMER);

        fill(TAX_ID,newUser.getTaxId());
        fill(COMPANY,newUser.getCompany());
        fill(FIRST_NAME,newUser.getFirstName());
        fill(LAST_NAME, newUser.getLastName());
        fill(ADDRESS_1,newUser.getAddress());
        fill(POSTCODE,newUser.getPostCode());
        fill(CITY,newUser.getCity());
        fill(EMAIL,newUser.getEmail());
        fill(PHONE,newUser.getPhone());
        fill(PASSWORD,newUser.getPassword());
        fill(CONFIRM_PASSWORD,newUser.getPassword());

        Select countrySelection = new Select(driver.findElement(COUNTRY));
        countrySelection.selectByVisibleText(newUser.getCountry());
        Select zoneSelection = new Select(driver.findElement(ZONE_STATE_PROVINCE));
        newUser.setZone(getRandomState());
        zoneSelection.selectByVisibleText(newUser.getZone());

        click(CREATE_ACCOUNT);
        click(LOGOUT);

        fill(LOGIN, newUser.getEmail());
        fill(PSW, newUser.getPassword());
        click(LOGIN_BTN);
        click(LOGOUT);



    }

    private String getRandomState(){
        List<WebElement> states = driver.findElements(ZONE_STATE_PROVINCE_OPTIONS);
        int index = new Random().nextInt(states.size());
        return states.get(index).getText();
    }

    @After
    public void stopBrowser(){
        stop();
    }
}
