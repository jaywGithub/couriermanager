package com.example.jayson.assignment6.services.customerservices.customer.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.customer.Customer;
import com.example.jayson.assignment6.factories.customer.CustomerFactory;
import com.example.jayson.assignment6.repository.customerrepository.customer.CustomerRepository;
import com.example.jayson.assignment6.repository.customerrepository.customer.Impl.CustomerRepositoryImpl;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class CustomerServiceImpl extends IntentService implements CustomerService {

    private final CustomerRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.customerServices.customer.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.customerServices.customer.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.customerServices.customer.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.customerServices.customer.Impl.extra.UPDATE";

    private static CustomerServiceImpl service = null;

    public static CustomerServiceImpl getInstance() {
        if (service == null)
            service = new CustomerServiceImpl();
        return service;
    }

    private CustomerServiceImpl() {
        super("CustomerServiceImpl");
        repo = new CustomerRepositoryImpl(App.getAppContext());
    }

    @Override
    public String activateAccount(String name, String surname, String contactNumber) {
        if (true) {
            Customer settings = CustomerFactory.getCustomer(name, surname, contactNumber);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addCustomer(Context context, Customer customer) {

        Intent intent = new Intent(context, CustomerServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, customer);
        context.startService(intent);

    }

    @Override
    public void updateCustomer(Context context, Customer customer) {

        Intent intent = new Intent(context, CustomerServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, customer);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Customer customer = (Customer) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(customer);
            } else if (ACTION_UPDATE.equals(action)) {
                final Customer customer = (Customer) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(customer);
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
