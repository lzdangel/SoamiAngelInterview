package com.company.clientservice.controller;

import com.company.clientservice.service.ServiceLayer;
import com.company.clientservice.viewmodel.ShippingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class Controller {

    @Autowired
    ServiceLayer serviceLayer;

    public Controller(ServiceLayer serviceLayer){
        this.serviceLayer = serviceLayer;
    }

    @RequestMapping(value = "clientfe/addshipment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    ShippingViewModel addShipping(@RequestBody ShippingViewModel svm){

        return serviceLayer.addShipping(svm);

    }

    @RequestMapping(value = "clientfe/shipment/{trackingNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    ShippingViewModel getShipping(@PathVariable int trackingNumer){

        return serviceLayer.getShipping(trackingNumer);
    }
}
