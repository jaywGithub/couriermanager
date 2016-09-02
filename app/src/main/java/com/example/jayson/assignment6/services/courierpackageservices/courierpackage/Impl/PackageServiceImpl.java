package com.example.jayson.assignment6.services.courierpackageservices.courierpackage.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.courierpackage.CourierPackage;
import com.example.jayson.assignment6.factories.courierpackage.PackageFactory;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl.PackageRepositoryImpl;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.PackageRepository;
import com.example.jayson.assignment6.services.courierpackageservices.courierpackage.PackageService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class PackageServiceImpl extends IntentService implements PackageService {

    private final PackageRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.extra.UPDATE";

    private static PackageServiceImpl service = null;

    public static PackageServiceImpl getInstance() {
        if (service == null)
            service = new PackageServiceImpl();
        return service;
    }

    private PackageServiceImpl() {
        super("PackageServiceImpl");
        repo = new PackageRepositoryImpl(App.getAppContext());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final CourierPackage pack = (CourierPackage) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(pack);
            } else if (ACTION_UPDATE.equals(action)) {
                final CourierPackage pack = (CourierPackage) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(pack);
            }
        }

    }

    @Override
    public String activateAccount(String description) {

        if (true) {
            CourierPackage settings = PackageFactory.getPackage(description);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addPackage(Context context, CourierPackage pack) {

        Intent intent = new Intent(context, PackageServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, pack);
        context.startService(intent);

    }

    @Override
    public void updatePackage(Context context, CourierPackage pack) {

        Intent intent = new Intent(context, PackageServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, pack);
        context.startService(intent);

    }

    /*private void updateAddress(PackageSize packageSize) {
        //POST and Save Local
        try {
            PackageSize updatedAddress = api.updatePersonAddress(packageSize);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(PackageSize packageSize) {
        //POST and Save Local
        try {
            PackageSize createdAddress = api.createPersonAddress(packageSize);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
