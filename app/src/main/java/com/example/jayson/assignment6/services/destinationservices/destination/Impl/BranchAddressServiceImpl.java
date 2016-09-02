package com.example.jayson.assignment6.services.destinationservices.destination.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.destination.BranchAddress;
import com.example.jayson.assignment6.factories.destination.BranchAddressFactory;
import com.example.jayson.assignment6.repository.destinationrepository.destination.BranchAddressRepository;
import com.example.jayson.assignment6.repository.destinationrepository.destination.Impl.BranchAddressRepositoryImpl;
import com.example.jayson.assignment6.services.destinationservices.destination.BranchAddressService;

/**
 * Created by JAYSON on 2016-05-07.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class BranchAddressServiceImpl extends IntentService implements BranchAddressService{

    private final BranchAddressRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.extra.UPDATE";

    private static BranchAddressServiceImpl service = null;

    public static BranchAddressServiceImpl getInstance() {
        if (service == null)
            service = new BranchAddressServiceImpl();
        return service;
    }

    private BranchAddressServiceImpl() {
        super("BranchAddressServiceImpl");
        repo = new BranchAddressRepositoryImpl(App.getAppContext());
    }

    @Override
    public String activateAccount(String addressID, String cityName, String areaName) {
        if (true) {
            BranchAddress settings = BranchAddressFactory.getBranchAddress(addressID, cityName, areaName);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addBranchAddress(Context context, BranchAddress branchAddress) {

        Intent intent = new Intent(context, BranchAddressServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, branchAddress);
        context.startService(intent);

    }

    @Override
    public void updateBranchAddress(Context context, BranchAddress branchAddress) {

        Intent intent = new Intent(context, BranchAddressServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, branchAddress);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final BranchAddress branchAddress = (BranchAddress) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(branchAddress);
            } else if (ACTION_UPDATE.equals(action)) {
                final BranchAddress branchAddress = (BranchAddress) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(branchAddress);
            }
        }

    }

    /*private void updateAddress(BranchAddress branchAddress) {
        //POST and Save Local
        try {
            BranchAddress updatedAddress = api.updatePersonAddress(branchAddress);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(BranchAddress branchAddress) {
        //POST and Save Local
        try {
            BranchAddress createdAddress = api.createPersonAddress(branchAddress);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
