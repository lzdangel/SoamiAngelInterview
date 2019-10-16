package com.company.uspsshipmentservice.model;

import java.util.Objects;

public class Shipment {

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

    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return getShippingId() == shipment.getShippingId() &&
                getTrackingNumber() == shipment.getTrackingNumber() &&
                Objects.equals(getName(), shipment.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShippingId(), getName(), getTrackingNumber());
    }
}
