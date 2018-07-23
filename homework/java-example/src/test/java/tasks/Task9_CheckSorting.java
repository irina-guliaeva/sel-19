package tasks;

import helpers.IPageElements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task9_CheckSorting extends Base implements IPageElements {
    /**
     * Задание 9
     * Сделайте сценарии, которые проверяют сортировку стран и геозон (штатов) в учебном приложении litecart.
     *
     * 1) на странице http://localhost/litecart/admin/?app=countries&doc=countries
     * а) проверить, что страны расположены в алфавитном порядке
     * б) для тех стран, у которых количество зон отлично от нуля -- открыть страницу этой страны и там проверить, что зоны расположены в алфавитном порядке
     *
     * 2) на странице http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones
     * зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке
     */
    private static final By BTN_CANCEL = By.cssSelector("button[name = cancel]");

    private static final By ROWS = By.cssSelector("table.dataTable tbody tr.row");
    private static final By COUNTRY_NAME_LINK = By.cssSelector("td:nth-child(5) a");
    private static final By AMOUNT_OF_ZONES_CELL = By.cssSelector("td:nth-child(6)");

    private static final By ZONE_NAME = By.cssSelector("table.dataTable tbody tr:not(.header) td:nth-child(3) input[type=hidden]");

    private static final By GEO_ZONE_COUNTRY_NAME_LINK = By.cssSelector("td:nth-child(3) a");
    private static final By GEO_ZONE_SELECTED_NAME = By.cssSelector("table.dataTable tbody tr:not(.header) td:nth-child(3) option[selected]");


    @Before
    public void runBrowser(){
        start();
    }


    @Test
    public void checkCountriesSorting(){
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        click(MAIN_MENU_LINK_COUNTRIES);

        temporaryLog("getting the names of presented countries");
        List<WebElement> rows = driver.findElements(ROWS);
        List<String> originalList = new ArrayList<String>();
        List<String> sortedList = new ArrayList<String>();
        for(WebElement row : rows){
            String countryName = row.findElement(COUNTRY_NAME_LINK).getText();
            originalList.add(countryName);
            sortedList.add(countryName);
        }
        Collections.sort(sortedList);
        temporaryLog("exp. list: "+sortedList.toString());
        temporaryLog("act. list: "+originalList.toString());
        assertEquals(sortedList,originalList);
        temporaryLog("countries presented in alphabetical order");
    }

    @Test
    public void checkCountryZones(){
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        click(MAIN_MENU_LINK_COUNTRIES);

        List<WebElement> rows = driver.findElements(ROWS);
        for(int i = 0; i < rows.size(); i++){
            int amountOfZones = Integer.parseInt(rows.get(i).findElement(AMOUNT_OF_ZONES_CELL).getText());
            if(amountOfZones>0){
                WebElement country = rows.get(i).findElement(COUNTRY_NAME_LINK);
                String countryName = country.getText();
                temporaryLog("checking zones for country ["+countryName+"]");
                country.click();
                List<String> originalList = getZonesForCurrentCountry();
                List<String> sortedList = originalList;
                Collections.sort(sortedList);
                temporaryLog("exp. list: "+sortedList.toString());
                temporaryLog("act. list: "+originalList.toString());
                assertEquals(sortedList,originalList);
                temporaryLog("geo zones for country ["+countryName+"] presented in alphabetical order");
                click(BTN_CANCEL);
                rows = driver.findElements(ROWS);
            }
        }

    }

    private List<String> getZonesForCurrentCountry(){
        List<WebElement> zones = driver.findElements(ZONE_NAME);
        List<String> list = new ArrayList<String>();
        for(WebElement zone : zones){
            list.add(zone.getAttribute("value"));
        }
        return list;
    }

    @Test
    public void checkGeoZonesPage(){
        navigateTo(LITECART_ADMIN);
        loginAs(ADMIN_LOGIN, ADMIN_PSW);
        click(MAIN_MENU_LINK_GEO_ZONES);

        List<WebElement> rows = driver.findElements(ROWS);
        for(int i = 0; i < rows.size(); i++){
            WebElement country = rows.get(i).findElement(GEO_ZONE_COUNTRY_NAME_LINK);
            String countryName = country.getText();
            temporaryLog("checking zones for country ["+countryName+"]");
            country.click();

            List<WebElement> zones = driver.findElements(GEO_ZONE_SELECTED_NAME);
            List<String> originalList = new ArrayList<String>();
            for(WebElement zone : zones){
                originalList.add(zone.getText());
            }
            List<String> sortedList = originalList;
            Collections.sort(sortedList);
            temporaryLog("exp. list: "+sortedList.toString());
            temporaryLog("act. list: "+originalList.toString());
            assertEquals(sortedList,originalList);
            temporaryLog("geo zones for country ["+countryName+"] presented in alphabetical order");
            click(BTN_CANCEL);
            rows = driver.findElements(ROWS);
        }

    }

    @After
    public void stopBrowser(){
        stop();
    }
}
