package com.example.jayson.assignment6.services.employeeservices.employee.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.jayson.assignment6.config.databases.util.App;
import com.example.jayson.assignment6.config.databases.util.DomainState;
import com.example.jayson.assignment6.domain.employee.Employee;
import com.example.jayson.assignment6.factories.employee.EmployeeFactory;
import com.example.jayson.assignment6.repository.employeerepository.employee.EmployeeRepository;
import com.example.jayson.assignment6.repository.employeerepository.employee.Impl.EmployeeRepositoryImpl;
import com.example.jayson.assignment6.services.employeeservices.employee.EmployeeService;

/**
 * Created by JAYSON on 2016-05-08.
 */

/*Utilised intent service because each task needs to be handled individually and not reduce the application's performance*/
public class EmployeeServiceImpl extends IntentService implements EmployeeService {

    private final EmployeeRepository repo;

    private static final String ACTION_ADD = "com.example.jayson.assignment6.services.employeeServices.employee.Impl.action.ADD";
    private static final String ACTION_UPDATE = "com.example.jayson.assignment6.services.employeeServices.employee.Impl.action.UPDATE";

    private static final String EXTRA_ADD = "com.example.jayson.assignment6.services.employeeServices.employee.Impl.extra.ADD";
    private static final String EXTRA_UPDATE = "com.example.jayson.assignment6.services.employeeServices.employee.Impl.extra.UPDATE";

    private static EmployeeServiceImpl service = null;

    public static EmployeeServiceImpl getInstance() {
        if (service == null)
            service = new EmployeeServiceImpl();
        return service;
    }

    private EmployeeServiceImpl() {
        super("EmployeeServiceImpl");
        repo = new EmployeeRepositoryImpl(App.getAppContext());
    }

    @Override
    public String activateAccount(String name) {

        if (true) {
            Employee settings = EmployeeFactory.getEmployee(name);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public void addEmployee(Context context, Employee employee) {

        Intent intent = new Intent(context, EmployeeServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, employee);
        context.startService(intent);

    }

    @Override
    public void updateEmployee(Context context, Employee employee) {

        Intent intent = new Intent(context, EmployeeServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, employee);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final Employee employee = (Employee) intent.getSerializableExtra(EXTRA_ADD);
                //postAddress(employee);
            } else if (ACTION_UPDATE.equals(action)) {
                final Employee employee = (Employee) intent.getSerializableExtra(EXTRA_UPDATE);
                //updateAddress(employee);
            }
        }

    }

    /*private void updateAddress(Employee employee) {
        //POST and Save Local
        try {
            Employee updatedAddress = api.updatePersonAddress(employee);
            repo.save(updatedAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postAddress(Employee employee) {
        //POST and Save Local
        try {
            Employee createdAddress = api.createPersonAddress(employee);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}
