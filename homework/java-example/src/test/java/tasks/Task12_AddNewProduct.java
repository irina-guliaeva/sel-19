package tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Task12_AddNewProduct extends Base{
    @Before
    public void runBrowser(){
        start();
    }

    @Test
    public void addNewProduct(){

    }

    @After
    public void stopBrowser(){
        stop();
    }
}
