package com.example.jayson.assignment6.services.couriercostservices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.services.couriercostservices.settings.Impl.ActivateSizeCostServiceImpl;

import junit.framework.Assert;

/**
 * Created by JAYSON on 2016-05-08.
 */
public class ActivateSizeCostServiceTest extends AndroidTestCase {

    private ActivateSizeCostServiceImpl activateService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ActivateSizeCostServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivateSizeCostServiceImpl.ActivateServiceLocalBinder binder
                    = (ActivateSizeCostServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            isBound = false;
        }
    };

    public void testActivateAccount() throws Exception {
        String activate = activateService.activateAccount("mediumBox", 30.0);
        Assert.assertEquals("ACTIVATED", activate);

    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = activateService.isAccountActivated();
        Assert.assertTrue("ACTIVATED", activated);

    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = activateService.deactivateAccount();
        Assert.assertTrue("ACTIVATED", deactivated);

    }
}
