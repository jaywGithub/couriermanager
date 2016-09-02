package com.example.jayson.assignment6.services.couriercostservices.settings;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateSizeCostService {

    String activateAccount(String size, double cost);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
