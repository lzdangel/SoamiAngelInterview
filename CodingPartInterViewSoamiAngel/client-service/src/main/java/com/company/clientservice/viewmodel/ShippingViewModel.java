package com.company.clientservice.viewmodel;

import java.util.Objects;

public class ShippingViewModel {
    private int shippingId;
    private String name;
    private int trackingNumber;

    //getters and setters

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }


    //equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingViewModel that = (ShippingViewModel) o;
        return getShippingId() == that.getShippingId() &&
                getTrackingNumber() == that.getTrackingNumber() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShippingId(), getName(), getTrackingNumber());
    }
}
