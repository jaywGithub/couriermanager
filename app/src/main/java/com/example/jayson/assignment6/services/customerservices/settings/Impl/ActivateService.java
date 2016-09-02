package com.example.jayson.assignment6.services.customerservices.settings.Impl;

/**
 * Created by JAYSON on 2016-05-07.
 */
public interface ActivateService {

    String activateAccount(String addressID, String cityName, String areaName);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
