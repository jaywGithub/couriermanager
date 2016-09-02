package com.example.jayson.assignment6.services.courierpackageservices;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.jayson.assignment6.services.courierpackageservices.courierpackage.Impl.PackageServiceImpl;

import junit.framework.Assert;

/**
 * Created by JAYSON on 2016-05-08.
 */
public class ActivatePackageServiceTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testUserContactService(){
        Intent intent = new Intent(getContext(), PackageServiceImpl.class);
        super.mContext.startService(intent);
        Assert.assertEquals("Clothes", getContext());
    }

    /*private ActivatePackageServiceImpl activateService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), ActivatePackageServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ActivatePackageServiceImpl.ActivateServiceLocalBinder binder
                    = (ActivatePackageServiceImpl.ActivateServiceLocalBinder) service;
            activateService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testActivateAccount() throws Exception {
        String activate = activateService.activateAccount("Clothes");
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
