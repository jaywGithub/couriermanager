package com.example.jayson.assignment6.services.destinationservices.destination.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.destination.Branch;
import com.example.jayson.assignment6.factories.destination.BranchFactory;
import com.example.jayson.assignment6.repository.destinationrepository.destination.BranchRepository;
import com.example.jayson.assignment6.repository.destinationrepository.destination.Impl.BranchRepositoryImpl;
import com.example.jayson.assignment6.services.destinationservices.destination.BranchService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class BranchServiceImpl extends IntentService implements BranchService {

    private final BranchRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.destinationServices.destination.Impl.extra.UPDATE";

    private static BranchServiceImpl service = null;

    public static BranchServiceImpl getInstance() {
        if (service == null)
            service = new BranchServiceImpl();
        return service;
    }

    private BranchServiceImpl() {
        super("BranchServiceImpl");
        repo = new BranchRepositoryImpl(App.getAppContext());
    }

    @Override
    public String activateAccount(String name) {
        if (true) {
            Branch settings = BranchFactory.getBranch(name);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addBranch(Context context, Branch branch) {

        Intent intent = new Intent(context, BranchServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, branch);
        context.startService(intent);

    }

    @Override
    public void updateBranch(Context context, Branch branch) {

        Intent intent = new Intent(context, BranchServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, branch);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Branch branch = (Branch) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(branch);
            } else if (ACTION_UPDATE.equals(action)) {
                final Branch branch = (Branch) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(branch);
            }
        }

    }

    /*private void updateAddress(Branch branch) {
        //POST and Save Local
        try {
            Branch updatedAddress = api.updatePersonAddress(branch);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(Branch branch) {
        //POST and Save Local
        try {
            Branch createdAddress = api.createPersonAddress(branch);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
