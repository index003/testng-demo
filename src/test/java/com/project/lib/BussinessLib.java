package com.project.lib;

import com.autoframe.lib.DataStore;

public class BussinessLib extends WebdriverLibExtension{


    public void login() throws Exception {
        super.newClick(ObjectStore.LOGIN_XPATH);
        super.sendKey(ObjectStore.USERNAME_XPATH, DataStore.D_Username);
        super.sendKey(ObjectStore.PASSWORD_XPATH,DataStore.D_Password);
        super.sendKey(ObjectStore.PASSWORD_XPATH,DataStore.D_Enter);
        Thread.sleep(5000);
    }
}
