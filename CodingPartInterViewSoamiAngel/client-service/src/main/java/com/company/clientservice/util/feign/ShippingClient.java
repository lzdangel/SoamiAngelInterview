package com.company.clientservice.util.feign;

import com.company.clientservice.viewmodel.ShippingViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usps-shipment-service")
@RequestMapping("/shipment")
public interface ShippingClient {

    @PostMapping
    ShippingViewModel addShipping(@RequestBody ShippingViewModel svm);

    @GetMapping("/{trackingNumber}")
    ShippingViewModel getShipping(@PathVariable int trackingNumber);
}
