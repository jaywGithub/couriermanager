package com.example.jayson.assignment6.services.destinationservices.destination;

import android.content.Context;

import com.example.jayson.assignment6.domain.destination.Branch;

/**
 * Created by JAYSON on 2016-05-08.
 */
public interface BranchService {

    String activateAccount(String name);

    void addBranch(Context context, Branch branch);

    void updateBranch(Context context, Branch branch);
}
