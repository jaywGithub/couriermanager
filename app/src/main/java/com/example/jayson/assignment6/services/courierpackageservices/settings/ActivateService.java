package com.example.jayson.assignment6.services.courierpackageservices.settings;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface ActivateService {

    String activateAccount(String smallBox, String mediumBox, String largeBox);

    boolean isAccountActivated();

    boolean deactivateAccount();
}
