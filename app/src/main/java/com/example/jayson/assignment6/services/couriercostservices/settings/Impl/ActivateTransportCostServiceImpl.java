package com.example.jayson.assignment6.services.couriercostservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.TransportCost;
import com.example.jayson.assignment6.factories.couriercost.TransportCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.settings.TransportCostTypeRepository;
import com.example.jayson.assignment6.services.couriercostservices.settings.ActivateTransportCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateTransportCostServiceImpl extends Service implements ActivateTransportCostService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private TransportCostTypeRepository repo;

    public ActivateTransportCostServiceImpl(){}

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateTransportCostServiceImpl getService() {
            return ActivateTransportCostServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(String type, double cost) {

        if (true) {
            TransportCost settings = TransportCostFactory.getTransportCost(type, cost);
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
