package com.example.jayson.assignment6.services.destinationservices.destination;

import android.content.Context;

import com.example.jayson.assignment6.domain.destination.BranchAddress;

/**
 * Created by JAYSON on 2016-05-07.
 */
public interface BranchAddressService {

    String activateAccount(String addressID, String cityName, String areaName);

    void addBranchAddress(Context context, BranchAddress branchAddress);

    void updateBranchAddress(Context context, BranchAddress branchAddress);
}
