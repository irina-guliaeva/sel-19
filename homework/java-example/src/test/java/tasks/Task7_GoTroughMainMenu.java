package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Base;

import java.util.List;

import static org.junit.Assert.*;

public class Task7_GoTroughMainMenu extends Base {

    /**
     * Cделайте сценарий, который выполняет следующие действия в учебном приложении litecart.     *
     * 1) входит в панель администратора http://localhost/litecart/admin
     * 2) прокликивает последовательно все пункты меню слева, включая вложенные пункты
     * 3) для каждой страницы проверяет наличие заголовка (то есть элемента с тегом h1)
     * Можно оформить сценарий либо как тест, либо как отдельный исполняемый файл.
     */

    private By MAIN_MENU_LIST = By.cssSelector("li#app-");
    By SUB_MENU_LIST_OF_SELECTED_MAIN_MENU_ITEM = By.cssSelector("li#app-.selected li");
    By PAGE_TITLE = By.cssSelector("h1");


    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkSections(){
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);

        List<WebElement> mainMenuItems = driver.findElements(MAIN_MENU_LIST);
        for(int i = 0; i < mainMenuItems.size(); i++){
            temporaryLog("clicking menu item ["+mainMenuItems.get(i).getText()+"]");
            mainMenuItems.get(i).click();
            List<WebElement> subMenuItems = driver.findElements(SUB_MENU_LIST_OF_SELECTED_MAIN_MENU_ITEM);
            if(subMenuItems.size()>0){
                for(int j = 0; j < subMenuItems.size(); j++){
                    temporaryLog("clicking sub menu item ["+subMenuItems.get(j).getText()+"]");
                    subMenuItems.get(j).click();
                    assertTrue(isElementPresent(PAGE_TITLE));
                    subMenuItems = driver.findElements(SUB_MENU_LIST_OF_SELECTED_MAIN_MENU_ITEM);
                }
            }else{
                assertTrue(isElementPresent(PAGE_TITLE));
            }
            mainMenuItems = driver.findElements(MAIN_MENU_LIST);
        }
    }

    @After
    public void stopBrowser(){
        stop();
    }

}
