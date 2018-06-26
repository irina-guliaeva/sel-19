import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginTests extends Base{

    /**
     * Задание 3
     * Сделайте сценарий для логина в панель администрирования учебного приложения http://localhost/litecart/admin/.     *
     * Проверки можно пока никакие не делать, только действия -- заполнение полей, нажатия на кнопки и ссылки.     *
     * Можно оформить сценарий либо как тест, либо как отдельный исполняемый файл.     *
     * Не забывайте о том, что браузер должен останавливаться, даже если возникли какие-либо ошибки во время выполнения сценария.
     */


    private final static String LITECART_ADMIN = "http://localhost/litecart/admin/";
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PSW = "admin";

    private final static By LITECART_LOGO = By.xpath("//img[@title='My Store']");
    private final static By ERROR_MSG = By.xpath("//i[@class='fa fa-exclamation-triangle']");

    private final static By LOGIN_FIELD = By.name("username");
    private final static By PSW_FIELD = By.name("password");
    private final static By LOGIN_BTN = By.name("login");




    @Before
    public void runBrowser(){
        start();
    }


    /**
     * Тест [successfulLogin] идет на страницу входа для админской консоли
     * Заполняет поля [Username] и [Password] корректными данными
     * Нажимает кнопку [Login]
     * Ждет появления логотипа Litecart
     */
    @Test
    public void successfulLogin(){
        temporaryLog("running the test [successful Login]");
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        waitForAppearanceOf(LITECART_LOGO);
    }

    /**
     * Тест [wrongPassword] идет на страницу входа для админской консоли
     * Заполняет поле [Username], поле [Password] оставляет пустым
     * Нажимает кнопку [Login]
     * Ждет появления сообщения об ошибке
     * На данный момент сообщение не распознается как собщение о неправильном пароле, просто как сообщение об ошибке
     */
    @Test
    public void wrongPassword(){
        temporaryLog("running the test [unsuccessful login with wrong password]");
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, "");
        waitForAppearanceOf(ERROR_MSG);
        temporaryLog("trying to login successfully to aviod the blocking");
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        waitForAppearanceOf(LITECART_LOGO);

    }

    /**
     * Тест [wrongUser] идет на страницу входа для админской консоли
     * Заполняет поле [Username] не существующим в базе значением, поле [Password] оставляет пустым
     * Нажимает кнопку [Login]
     * Ждет появления сообщения об ошибке
     * На данный момент сообщение не распознается как собщение о неправильном пароле, просто как сообщение об ошибке
     */
    @Test
    public void wrongUser(){
        temporaryLog("running the test [unsuccessful login with wrong user]");
        navigateTo(LITECART_ADMIN);
        loginAs("Guliaeva", "");
        waitForAppearanceOf(ERROR_MSG);
        temporaryLog("trying to login successfully to aviod the blocking");
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        waitForAppearanceOf(LITECART_LOGO);

    }

    @After
    public void stopBrowser(){
        stop();
    }

    private void loginAs(String login, String password){
        temporaryLog("logging as user ["+login+"] with password ["+password+"]");
        fill(LOGIN_FIELD,login);
        fill(PSW_FIELD,password);
        clickBtn(LOGIN_BTN);
    }




}
