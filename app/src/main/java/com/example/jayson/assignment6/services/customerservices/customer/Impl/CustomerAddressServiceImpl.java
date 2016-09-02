package com.example.jayson.assignment6.services.customerservices.customer.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.customer.CustomerAddress;
import com.example.jayson.assignment6.factories.customer.CustomerAddressFactory;
import com.example.jayson.assignment6.repository.customerrepository.customer.CustomerAddressRepository;
import com.example.jayson.assignment6.repository.customerrepository.customer.Impl.CustomerAddressRepositoryImpl;

/**
 * Created by JAYSON on 2016-05-07.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class CustomerAddressServiceImpl extends IntentService implements CustomerAddressService {

    private final CustomerAddressRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.customerServices.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.customerServices.customer.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.customerServices.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.customerServices.customer.Impl.extra.UPDATE";

    private static CustomerAddressServiceImpl service = null;

    public static CustomerAddressServiceImpl getInstance() {
        if (service == null)
            service = new CustomerAddressServiceImpl();
        return service;
    }

    private CustomerAddressServiceImpl() {
        super("CustomerAddressServiceImpl");
        repo = new CustomerAddressRepositoryImpl(App.getAppContext());
    }

    @Override
    public String activateAccount(String addressID, String cityName, String areaName) {
        if (true) {
            CustomerAddress settings = CustomerAddressFactory.getCustomerAddress(addressID, cityName, areaName);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addCustomerAddress(Context context, CustomerAddress customerAddress) {

        Intent intent = new Intent(context, CustomerAddressServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, customerAddress);
        context.startService(intent);

    }

    @Override
    public void updateCustomerAddress(Context context, CustomerAddress customerAddress) {

        Intent intent = new Intent(context, CustomerAddressServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, customerAddress);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final CustomerAddress customerAddress = (CustomerAddress) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(customerAddress);
            } else if (ACTION_UPDATE.equals(action)) {
                final CustomerAddress customerAddress = (CustomerAddress) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(customerAddress);
            }
        }

    }

        /*private void updateAddress(CustomerAddress customerAddress) {
        //POST and Save Local
        try {
            CustomerAddress updatedAddress = api.updatePersonAddress(customerAddress);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(CustomerAddress customerAddress) {
        //POST and Save Local
        try {
            CustomerAddress createdAddress = api.createPersonAddress(customerAddress);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
