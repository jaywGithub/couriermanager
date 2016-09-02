package com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage;

import android.test.AndroidTestCase;

import com.example.jayson.assignment6.domain.courierpackage.CourierPackage;
import com.example.jayson.assignment6.repository.courierpackagerepository.courierpackage.Impl.PackageRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by JAYSON on 2016-04-24.
 */
public class CourierPackageRepositoryTest extends AndroidTestCase {

    private static final String TAG = "PACKAGE TEST";
    private Long id;

    public void testCreateReadUpdateDelete()throws Exception
    {
        PackageRepository repo = new PackageRepositoryImpl(this.getContext());
        // CREATE
        CourierPackage createEntity = new CourierPackage.Builder()
                .description("clothes")
                .build();
        CourierPackage insertedEntity = repo.save(createEntity);
        id = insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE",insertedEntity);

        //READ ALL
        Set<CourierPackage> courierPackages = repo.findAll();
        Assert.assertTrue(TAG + " READ ALL", courierPackages.size()>0);

        //READ ENTITY
        CourierPackage entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY",entity);

        //UPDATE ENTITY
        CourierPackage updateEntity = new CourierPackage.Builder()
                .copy(entity)
                .description("electronics")
                .build();
        repo.update(updateEntity);
        CourierPackage newEntity = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY","electronics",newEntity.getDescription());

        // DELETE ENTITY
        repo.delete(updateEntity);
        CourierPackage deletedEntity = repo.findById(id);
        Assert.assertNull(TAG + " DELETE",deletedEntity);
    }
}
