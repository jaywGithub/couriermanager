package com.example.jayson.assignment6.services.customerservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.services.customerservices.customer.Impl.CustomerServiceImpl;
import com.example.jayson.assignment6.services.customerservices.settings.Impl.ActivateCustomerServiceImpl;

import junit.framework.Assert;

/**
 * Created by JAYSON on 2016-05-08.
 */
public class ActivateCustomerServiceTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testUserContactService(){
        Intent intent = new Intent(getContext(), CustomerServiceImpl.class);
        super.mContext.startService(intent);
        Assert.assertEquals("Jayson", getContext());
    }

    /*private ActivateCustomerServiceImpl activateService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ActivateCustomerServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivateCustomerServiceImpl.ActivateServiceLocalBinder binder
                    = (ActivateCustomerServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testActivateAccount() throws Exception {
        String activate = activateService.activateAccount("Jayson", "Peters", "021 123 4567");
        Assert.assertEquals("ACTIVATED", activate);

    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = activateService.isAccountActivated();
        Assert.assertTrue("ACTIVATED", activated);

    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = activateService.deactivateAccount();
        Assert.assertTrue("ACTIVATED", deactivated);

    }*/
}
