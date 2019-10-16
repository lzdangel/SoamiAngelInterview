package com.company.uspsshipmentservice.service;

import com.company.uspsshipmentservice.dao.ShippingDao;
import com.company.uspsshipmentservice.model.Shipment;
import com.company.uspsshipmentservice.viewmodel.ShippingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    ShippingDao shippingDao;

    @Autowired
    public ServiceLayer(ShippingDao shippingDao){
        this.shippingDao = shippingDao;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Add a shipment
    public ShippingViewModel addShipment(ShippingViewModel svm){

        return buildShippingViewModel(shippingDao.addShipment(buildShipment(svm)));

    }

    //Get a shipment
    public ShippingViewModel getShipmentByTrackingNumber(int trackingNumber){

        return buildShippingViewModel(shippingDao.getShipment(trackingNumber));
    }

    //helper methods

    ShippingViewModel buildShippingViewModel(Shipment shipment){

        ShippingViewModel svm = new ShippingViewModel();

        if(shipment == null){
            return null;
        }else{
            svm.setShippingId(shipment.getShippingId());
            svm.setName(shipment.getName());
            svm.setTrackingNumber(shipment.getTrackingNumber());
        }

        return svm;
    }

    Shipment buildShipment(ShippingViewModel svm){

        Shipment shipment = new Shipment();

        if(svm == null){
            return null;
        }else{
            shipment.setShippingId(svm.getShippingId());
            shipment.setName(svm.getName());
            shipment.setTrackingNumber(svm.getTrackingNumber());
        }

        return shipment;
    }
}
