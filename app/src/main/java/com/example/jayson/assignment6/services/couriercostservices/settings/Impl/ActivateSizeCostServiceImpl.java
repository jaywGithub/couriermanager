package com.example.jayson.assignment6.services.couriercostservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.SizeCost;
import com.example.jayson.assignment6.factories.couriercost.SizeCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.SizeCostTypeRepository;
import com.example.jayson.assignment6.services.couriercostservices.settings.ActivateSizeCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateSizeCostServiceImpl extends Service implements ActivateSizeCostService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SizeCostTypeRepository repo;

    public ActivateSizeCostServiceImpl(){}

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateSizeCostServiceImpl getService() {
            return ActivateSizeCostServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(String size, double cost) {

        if (true) {
            SizeCost settings = SizeCostFactory.getSizeCost(size, cost);
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
