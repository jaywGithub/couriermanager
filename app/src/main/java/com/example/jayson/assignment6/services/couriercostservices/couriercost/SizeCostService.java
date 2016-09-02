package com.example.jayson.assignment6.services.couriercostservices.couriercost;

import android.content.Context;

import com.example.jayson.assignment6.domain.couriercost.SizeCost;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface SizeCostService {

    String activateAccount(String size, double cost);

    void addSizeCost(Context context, SizeCost sizeCost);

    void updateSizeCost(Context context, SizeCost sizeCost);
}
