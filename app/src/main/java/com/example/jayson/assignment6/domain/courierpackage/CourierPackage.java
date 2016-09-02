package com.example.jayson.assignment6.domain.courierpackage;

import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-17.
 */
public class CourierPackage implements Serializable {

    private Long id;
    private String description;

    private CourierPackage(){}

    public Long getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public CourierPackage(Builder builder)
    {
        this.id = builder.id;
        this.description = builder.description;
    }

    public static class Builder
    {
        private Long id;
        private String description;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder description(String value)
        {
            this.description = value;
            return this;
        }

        public Builder copy(CourierPackage value)
        {
            this.id = value.id;
            this.description = value.description;

            return this;
        }

        public CourierPackage build()
        {
            return new CourierPackage(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourierPackage aCourierPackage = (CourierPackage) o;

        return id != null ? id.equals(aCourierPackage.id) : aCourierPackage.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
