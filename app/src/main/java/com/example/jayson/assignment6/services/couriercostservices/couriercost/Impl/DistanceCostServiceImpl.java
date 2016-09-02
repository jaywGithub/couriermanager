package com.example.jayson.assignment6.services.couriercostservices.couriercost.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.DistanceCost;
import com.example.jayson.assignment6.factories.couriercost.DistanceCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.DistanceCostRepository;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.DistanceCostRepositoryImpl;
import com.example.jayson.assignment6.services.couriercostservices.couriercost.DistanceCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class DistanceCostServiceImpl extends IntentService implements DistanceCostService {

    private final DistanceCostRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.UPDATE";

    private static DistanceCostServiceImpl service = null;

    public static DistanceCostServiceImpl getInstance() {
        if (service == null)
            service = new DistanceCostServiceImpl();
        return service;
    }

    private DistanceCostServiceImpl() {
        super("DistanceCostServiceImpl");
        repo = new DistanceCostRepositoryImpl(App.getAppContext());
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
    public void addDistanceCost(Context context, DistanceCost distanceCost) {

        Intent intent = new Intent(context, DistanceCostServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, distanceCost);
        context.startService(intent);

    }

    @Override
    public void updateDistanceCost(Context context, DistanceCost distanceCost) {

        Intent intent = new Intent(context, DistanceCostServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, distanceCost);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final DistanceCost distanceCost = (DistanceCost) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(distanceCost);
            } else if (ACTION_UPDATE.equals(action)) {
                final DistanceCost distanceCost = (DistanceCost) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(distanceCost);
            }
        }

    }

    /*private void updateAddress(DistanceCost distanceCost) {
        //POST and Save Local
        try {
            DistanceCost updatedAddress = api.updatePersonAddress(distanceCost);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(DistanceCost distanceCost) {
        //POST and Save Local
        try {
            DistanceCost createdAddress = api.createPersonAddress(distanceCost);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
