package com.example.jayson.assignment6.services.couriercostservices.couriercost.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.SizeCost;
import com.example.jayson.assignment6.factories.couriercost.SizeCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.SizeCostRepositoryImpl;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.SizeCostRepository;
import com.example.jayson.assignment6.services.couriercostservices.couriercost.SizeCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class SizeCostServiceImpl extends IntentService implements SizeCostService {

    private final SizeCostRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.UPDATE";

    private static SizeCostServiceImpl service = null;

    public static SizeCostServiceImpl getInstance() {
        if (service == null)
            service = new SizeCostServiceImpl();
        return service;
    }

    private SizeCostServiceImpl() {
        super("SizeCostServiceImpl");
        repo = new SizeCostRepositoryImpl(App.getAppContext());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final SizeCost sizeCost = (SizeCost) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(sizeCost);
            } else if (ACTION_UPDATE.equals(action)) {
                final SizeCost sizeCost = (SizeCost) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(sizeCost);
            }
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
    public void addSizeCost(Context context, SizeCost sizeCost) {

        Intent intent = new Intent(context, SizeCostServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, sizeCost);
        context.startService(intent);

    }

    @Override
    public void updateSizeCost(Context context, SizeCost sizeCost) {

        Intent intent = new Intent(context, SizeCostServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, sizeCost);
        context.startService(intent);

    }

    /*private void updateAddress(SizeCost sizeCost) {
        //POST and Save Local
        try {
            SizeCost updatedAddress = api.updatePersonAddress(sizeCost);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(SizeCost sizeCost) {
        //POST and Save Local
        try {
            SizeCost createdAddress = api.createPersonAddress(sizeCost);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
