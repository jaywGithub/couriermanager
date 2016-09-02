package com.example.jayson.assignment6.services.customerservices.settings.Impl;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateCustomerService {

    String activateAccount(String name, String surname, String contactNumber);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
