package com.example.jayson.assignment6.services.destinationservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.destination.Branch;
import com.example.jayson.assignment6.factories.destination.BranchFactory;
import com.example.jayson.assignment6.repository.destinationrepository.settings.SettingsRepository;
import com.example.jayson.assignment6.services.destinationservices.settings.ActivateBranchService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateBranchServiceImpl extends Service implements ActivateBranchService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    public ActivateBranchServiceImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateBranchServiceImpl getService() {
            return ActivateBranchServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(String name) {

        if (true) {
            Branch branch = BranchFactory.getBranch(name);
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

    /*private Settings createSettings(Settings settings) {
        repo = new SettingsRepositoryImpl(App.getAppContext());
        return repo.save(settings);
    }*/
}
