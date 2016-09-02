package com.example.jayson.assignment6.services.courierpackageservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.courierpackage.PackageSize;
import com.example.jayson.assignment6.factories.courierpackage.PackageSizeFactory;
import com.example.jayson.assignment6.repository.courierpackagerepository.settings.SettingsRepository;
import com.example.jayson.assignment6.services.courierpackageservices.settings.ActivateService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateServiceImpl extends Service implements ActivateService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateServiceImpl getService() {
            return ActivateServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(String smallBox, String mediumBox, String largeBox) {

        if (true) {
            PackageSize settings = PackageSizeFactory.getPackageSize(smallBox, mediumBox, largeBox);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size()>0;
    }

    @Override
    public boolean deactivateAccount() {
        int rows = repo.deleteAll();
        return rows > 0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    /*private Settings createSettings(Settings settings) {
        repo = new SettingsRepositoryImpl(App.getAppContext());
        return repo.save(settings);
    }*/
}
