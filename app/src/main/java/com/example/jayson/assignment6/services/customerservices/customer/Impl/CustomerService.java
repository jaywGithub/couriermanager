package com.example.jayson.assignment6.services.customerservices.customer.Impl;

import android.content.Context;

import com.example.jayson.assignment6.domain.customer.Customer;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface CustomerService {

    String activateAccount(String name, String surname, String contactNumber);

    void addCustomer(Context context, Customer customer);

    void updateCustomer(Context context, Customer customer);
}
