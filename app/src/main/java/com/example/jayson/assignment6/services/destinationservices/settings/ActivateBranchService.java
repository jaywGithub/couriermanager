package com.example.jayson.assignment6.services.destinationservices.settings;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateBranchService {

    String activateAccount(String name);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
