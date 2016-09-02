package com.example.jayson.assignment6.services.courierpackageservices.courierpackage.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.courierpackage.PackageSize;
import com.example.jayson.assignment6.factories.courierpackage.PackageSizeFactory;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl.PackageSizeRepositoryImpl;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.PackageSizeRepository;
import com.example.jayson.assignment6.services.courierpackageservices.courierpackage.PackageSizeService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class PackageSizeServiceImpl extends IntentService implements PackageSizeService {

    private final PackageSizeRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.packageSizeServices.courierPackage.Impl.extra.UPDATE";

    private static PackageSizeServiceImpl service = null;

    public static PackageSizeServiceImpl getInstance() {
        if (service == null)
            service = new PackageSizeServiceImpl();
        return service;
    }

    private PackageSizeServiceImpl() {
        super("PackageSizeServiceImpl");
        repo = new PackageSizeRepositoryImpl(App.getAppContext());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final PackageSize packageSize = (PackageSize) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(packageSize);
            } else if (ACTION_UPDATE.equals(action)) {
                final PackageSize packageSize = (PackageSize) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(packageSize);
            }
        }

    }

    @Override
    public String activateAccount(String smallBox, String mediumBox, String largeBox) {

        if (true) {
            PackageSize settings = PackageSizeFactory.getPackageSize(smallBox, mediumBox, largeBox);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addPackageSize(Context context, PackageSize packageSize) {

        Intent intent = new Intent(context, PackageSizeServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, packageSize);
        context.startService(intent);

    }

    @Override
    public void updatePackageSize(Context context, PackageSize packageSize) {

        Intent intent = new Intent(context, PackageSizeServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, packageSize);
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
