package tasks;

import helpers.IPageElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.Base;

import static helpers.RandomHelper.*;

import java.util.*;

/**
 * Задание 14
 * Сделайте сценарий, который проверяет, что ссылки на странице редактирования страны открываются в новом окне. *
 * Сценарий должен состоять из следующих частей: *
 * 1) зайти в админку
 * 2) открыть пункт меню Countries (или страницу http://localhost/litecart/admin/?app=countries&doc=countries)
 * 3) открыть на редактирование какую-нибудь страну или начать создание новой
 * 4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой --
 * они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
 *
 * Конечно, можно просто убедиться в том, что у ссылки есть атрибут target="_blank".
 * Но в этом упражнении требуется именно кликнуть по ссылке, чтобы она открылась в новом окне, потом переключиться в новое окно, закрыть его, вернуться обратно, и повторить эти действия для всех таких ссылок.
 */

public class Task14_CheckNewWindowOpened extends Base implements IPageElements {

    private static final By COUNTRIES_LINKS = By.cssSelector("form[name=countries_form] tr.row td:nth-child(5) a");
    private static final By EXTERNAL_LINKS  = By.cssSelector("a[target='_blank'] i.fa.fa-external-link")       ;

    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkNewWindowOpened(){
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        click(MAIN_MENU_LINK_COUNTRIES);
        List<WebElement> countries = driver.findElements(COUNTRIES_LINKS);
        WebElement link = countries.get(rnd.nextInt(countries.size()));
        link.click();
        String litecartApplicationWindow = driver.getWindowHandle();
        Set<String> listOfOpenedWindows = driver.getWindowHandles();
        List<WebElement> externalLinks = driver.findElements(EXTERNAL_LINKS);
        for(int i = 0; i < externalLinks.size(); i++){
            WebElement externalLink =  externalLinks.get(i);
            externalLink.click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(listOfOpenedWindows.size()+1));
            Set<String> newListOfOpenedWindows = driver.getWindowHandles();
            String newWindow = getNewHandel(listOfOpenedWindows, newListOfOpenedWindows);
            driver.switchTo().window(newWindow);
            temporaryLog("The title of the new window: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(litecartApplicationWindow);
            listOfOpenedWindows = driver.getWindowHandles();
        }
    }



    private String getNewHandel(Set<String> list, Set<String> newList){
        Iterator<String> handle = newList.iterator();
        while(handle.hasNext()){
            String s = handle.next();
            if(!list.contains(s)){
                return s;
            }
        }
        return null;
    }

    @After
    public void stopBrowser(){
        stop();
    }
}
