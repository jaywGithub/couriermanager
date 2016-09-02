package com.example.jayson.assignment6.services.customerservices.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.customer.Customer;
import com.example.jayson.assignment6.factories.customer.CustomerFactory;
import com.example.jayson.assignment6.repository.customerrepository.settings.SettingsRepository;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised bound service in order to have control over communication between the application and the services.
This lacks in intent services*/
public class ActivateCustomerServiceImpl extends Service implements ActivateCustomerService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    public ActivateCustomerServiceImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateCustomerServiceImpl getService() {
            return ActivateCustomerServiceImpl.this;
        }
    }

    @Override
    public String activateAccount(String name, String surname, String contactNumber) {

        if (true) {
            Customer customer = CustomerFactory.getCustomer(name, surname, contactNumber);
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
