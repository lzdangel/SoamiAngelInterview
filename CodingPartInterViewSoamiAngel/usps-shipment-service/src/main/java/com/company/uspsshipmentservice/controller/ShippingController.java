package com.company.uspsshipmentservice.controller;

import com.company.uspsshipmentservice.service.ServiceLayer;
import com.company.uspsshipmentservice.viewmodel.ShippingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class ShippingController {

    @Autowired
    ServiceLayer serviceLayer;

    //add
    @RequestMapping(value = "/shipment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ShippingViewModel addShipping(@RequestBody ShippingViewModel svm){
        return serviceLayer.addShipment(svm);
    }

    //get
    @RequestMapping(value = "/shipment/{trackingNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    ShippingViewModel getShipping(@PathVariable int trackingNumber){
        return serviceLayer.getShipmentByTrackingNumber(trackingNumber);
    }
}
