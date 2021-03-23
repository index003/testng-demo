package com.test.cases;

import com.autoframe.lib.DataStore;
import com.project.lib.ObjectStore;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataLnLoginTest1 {

    static WebBussinessLib DataLn = new WebBussinessLib();

    @BeforeTest
    public void setUpBeforeClass() throws Exception {
        DataLn.newSetup();
    }

    @AfterTest
    public void tearDownAfterClass() throws Exception{
        DataLn.newTeardown();
    }

    @Test
    public void testLogin() throws Exception{

        DataLn.newClick(ObjectStore.LOGIN_XPATH);
        DataLn.sendKey(ObjectStore.USERNAME_XPATH, DataStore.D_Username);
        DataLn.sendKey(ObjectStore.PASSWORD_XPATH,DataStore.D_Password);
        DataLn.submitEnter(ObjectStore.PASSWORD_XPATH);
        //DataLn.sendKey(ObjectStore.PASSWORD_XPATH,DataStore.D_Enter);
        Thread.sleep(5000);
    }
}
