package com.example.jayson.assignment6.services.employeeservices.settings;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateService {

    String activateAccount(String name);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
