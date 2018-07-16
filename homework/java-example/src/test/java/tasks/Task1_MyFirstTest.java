package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Task1_MyFirstTest {

    /**
     * Подготовьте инфраструктуру для выполнения домашних заданий:
     *
     * 1) Создайте репозиторий на сервисе GitHub, в который будут отправляться домашние задания. Для тех, кто раньше не работал с этим сервисом, внизу есть видео-инструкция. (любители C# при желании могут использовать сервис visualstudio.com, в этом случае не забудьте предоставить доступ тренерам к репозиторию -- barancev@gmail.com и cherednichenko@outlook.com).
     *
     * 2) Установите всё необходимое для работы программное обеспечение.
     *
     * 3) Создайте проект внутри локальной копии репозитория, подключите к проекту Selenium и сделайте небольшой работающий тест, который просто запускает браузер, открывает какую-нибудь страницу и закрывает браузер.
     *
     * 4) Уложите всё в репозиторий и синхронизируйте с удалённым сервером.
     */

    private final static String GOOGLE = "http://google.com";
    private final static By GOOGLE_SEARCH_FIELD = By.name("q");
    private final static By GOOGLE_SEARCH_BTN = By.name("btnK");


    private final static String MAVEN_CENTRAL = "http://search.maven.org";
    private final static By MAVEN_CENTRAL_SEARCH_FIELD = By.id("query");
    private final static By MAVEN_CENTRAL_SEARCH_BTN = By.id("queryButton");
    private final static By MAVEN_CENTRAL_SEARCH_RESULTS = By.xpath("//table[@id='resultTable']");

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start(){
        /* не совсем понятно каким образом в видеоуроке драйвер хрома подцепился самостоятельно
         * так же как и в записи я создала директорию С://Tools, но драйвер не подсасывается.
         * Пока что оставила такой вариант
         */
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest(){
        navigateTo(GOOGLE);
        fill(GOOGLE_SEARCH_FIELD, "webDriver");
        clickBtn(GOOGLE_SEARCH_BTN);
        waitForTitle("webDriver - Поиск в Google");
    }

    @Test
    public void mySecondTest(){
        navigateTo(MAVEN_CENTRAL);
        fill(MAVEN_CENTRAL_SEARCH_FIELD, "selenium java");
        clickBtn(MAVEN_CENTRAL_SEARCH_BTN);
        waitForAppearanceOf(MAVEN_CENTRAL_SEARCH_RESULTS);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }


    private void navigateTo(String url){
        driver.get(url);
    }

    private void fill(By fieldLocator, String value){
        WebElement field = driver.findElement(fieldLocator);
        field.clear();
        field.sendKeys(value);
    }

    private void clickBtn(By btnLocator){
        WebElement btn = driver.findElement(btnLocator);
        btn.click();
    }

    private void waitForTitle(String title){
        wait.until(titleIs(title));
    }

    private void waitForAppearanceOf(By element){
        wait.until(visibilityOfElementLocated(element));
    }

}
