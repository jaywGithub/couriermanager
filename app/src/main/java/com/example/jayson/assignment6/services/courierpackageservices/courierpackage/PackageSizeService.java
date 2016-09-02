package com.example.jayson.assignment6.services.courierpackageservices.courierpackage;

import android.content.Context;

import com.example.jayson.assignment6.domain.courierpackage.PackageSize;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface PackageSizeService {

    String activateAccount(String smallBox, String mediumBox, String largeBox);

    void addPackageSize(Context context, PackageSize packageSize);

    void updatePackageSize(Context context, PackageSize packageSize);
}
