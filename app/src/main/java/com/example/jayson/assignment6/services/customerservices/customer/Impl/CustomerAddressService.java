package com.example.jayson.assignment6.services.customerservices.customer.Impl;

import android.content.Context;

import com.example.jayson.assignment6.domain.customer.CustomerAddress;

/**
 * Created by JAYSON on 2016-05-07.
 */
public interface CustomerAddressService {

    String activateAccount(String addressID, String cityName, String areaName);

    void addCustomerAddress(Context context, CustomerAddress customerAddress);

    void updateCustomerAddress(Context context, CustomerAddress customerAddress);
}
