package com.example.jayson.assignment6.services.couriercostservices.couriercost;

import android.content.Context;

import com.example.jayson.assignment6.domain.couriercost.TransportCost;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface TransportCostService {

    String activateAccount(String type, double cost);

    void addSizeCost(Context context, TransportCost transportCost);

    void updateSizeCost(Context context, TransportCost transportCost);
}
