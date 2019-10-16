package com.company.clientservice.service;

import com.company.clientservice.util.feign.ShippingClient;
import com.company.clientservice.viewmodel.ShippingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {


    ShippingClient shippingClient;


    @Autowired
    public ServiceLayer(ShippingClient shippingClient){
        this.shippingClient = shippingClient;
    }

    //Add
    public ShippingViewModel addShipping(ShippingViewModel svm){
        return shippingClient.addShipping(svm);
    }

    //get
    public ShippingViewModel getShipping(int trackingNumber){
        return shippingClient.getShipping(trackingNumber);
    }
}


