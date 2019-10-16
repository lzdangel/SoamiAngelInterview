package com.company.uspsshipmentservice.dao;

import com.company.uspsshipmentservice.model.Shipment;

import java.util.List;

public interface ShippingDao {

    //Add a shipment
    Shipment addShipment(Shipment shipment);

    //get a shipment
    Shipment getShipment(int trackingNumber);

    //get all shipments
    List<Shipment> getAllShipments();

    //Delete
    void deleteShipment(int id);

}
