package com.example.jayson.assignment6.services.couriercostservices.couriercost.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.couriercost.TransportCost;
import com.example.jayson.assignment6.factories.couriercost.TransportCostFactory;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.Impl.TransportCostRepositoryImpl;
import com.example.jayson.assignment6.repository.couriercostrepository.couriercost.TransportCostRepository;
import com.example.jayson.assignment6.services.couriercostservices.couriercost.TransportCostService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class TransportCostServiceImpl extends IntentService implements TransportCostService {

    private final TransportCostRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.courierCostServices.courierCost.Impl.extra.UPDATE";

    private static TransportCostServiceImpl service = null;

    public static TransportCostServiceImpl getInstance() {
        if (service == null)
            service = new TransportCostServiceImpl();
        return service;
    }

    private TransportCostServiceImpl() {
        super("TransportCostServiceImpl");
        repo = new TransportCostRepositoryImpl(App.getAppContext());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final TransportCost transportCost = (TransportCost) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(transportCost);
            } else if (ACTION_UPDATE.equals(action)) {
                final TransportCost transportCost = (TransportCost) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(transportCost);
            }
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
    public void addSizeCost(Context context, TransportCost transportCost) {

        Intent intent = new Intent(context, TransportCostServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, transportCost);
        context.startService(intent);

    }

    @Override
    public void updateSizeCost(Context context, TransportCost transportCost) {

        Intent intent = new Intent(context, TransportCostServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, transportCost);
        context.startService(intent);

    }

    /*private void updateAddress(TransportCost transportCost) {
        //POST and Save Local
        try {
            TransportCost updatedAddress = api.updatePersonAddress(transportCost);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(TransportCost transportCost) {
        //POST and Save Local
        try {
            TransportCost createdAddress = api.createPersonAddress(transportCost);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
