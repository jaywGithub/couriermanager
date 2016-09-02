package com.example.jayson.assignment6.factories.courierpackage;

import com.example.jayson.assignment6.domain.courierpackage.CourierPackage;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class PackageFactory {

    public static CourierPackage getPackage(String description)
    {
        return new CourierPackage.Builder()
                .description(description)
                .build();
    }
}
