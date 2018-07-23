package tasks;

import org.junit.*;
import org.openqa.selenium.By;
import pages.Base;

public class Task3_LoginTests extends Base {

    /**
     * Задание 3
     * Сделайте сценарий для логина в панель администрирования учебного приложения http://localhost/litecart/admin/.     *
     * Проверки можно пока никакие не делать, только действия -- заполнение полей, нажатия на кнопки и ссылки.     *
     * Можно оформить сценарий либо как тест, либо как отдельный исполняемый файл.     *
     * Не забывайте о том, что браузер должен останавливаться, даже если возникли какие-либо ошибки во время выполнения сценария.
     */




    private final static By LITECART_LOGO = By.xpath("//img[@title='My Store']");
    private final static By ERROR_MSG = By.xpath("//i[@class='fa fa-exclamation-triangle']");






    @Before
    public void runBrowser(){
        start(Base.EDGE);
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






}
