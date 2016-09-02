package com.example.jayson.assignment6.services.couriercostservices.settings;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateTransportCostService {

    String activateAccount(String type, double cost);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
