package com.example.jayson.assignment6.services.couriercostservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.DistanceCost;
import com.example.jayson.assignment6.factories.couriercost.DistanceCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.DistanceCostTypeRepository;
import com.example.jayson.assignment6.services.couriercostservices.settings.ActivateDistanceCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateDistanceCostServiceImpl extends Service implements ActivateDistanceCostService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private DistanceCostTypeRepository repo;

    public ActivateDistanceCostServiceImpl(){}

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateDistanceCostServiceImpl getService() {
            return ActivateDistanceCostServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(double distance, double cost) {

        if (true) {
            DistanceCost settings = DistanceCostFactory.getDistanceCost(distance, cost);
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
