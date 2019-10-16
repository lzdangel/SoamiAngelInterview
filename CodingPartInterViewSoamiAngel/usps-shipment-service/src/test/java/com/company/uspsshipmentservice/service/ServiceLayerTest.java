package com.company.uspsshipmentservice.service;

import com.company.uspsshipmentservice.dao.ShippingDao;
import com.company.uspsshipmentservice.dao.ShippingDaoJdbcTemplateImpl;
import com.company.uspsshipmentservice.model.Shipment;
import com.company.uspsshipmentservice.viewmodel.ShippingViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ShippingDao shippingDao;

    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {

        setUpShippingDaoMock();
        serviceLayer = new ServiceLayer(shippingDao);
    }

    public void setUpShippingDaoMock() {
        shippingDao = mock(ShippingDaoJdbcTemplateImpl.class);

        Shipment shipment = new Shipment();

        shipment.setShippingId(1);
        shipment.setName("John Wick");
        shipment.setTrackingNumber(111111);

        //Calling object
        Shipment shipmentC = new Shipment();

        shipmentC.setName("John Wick");
        shipmentC.setTrackingNumber(111111);

        doReturn(shipment).when(shippingDao).addShipment(shipmentC);
        doReturn(shipment).when(shippingDao).getShipment(111111);

    }

    @Test
    public void addShipment() {
        ShippingViewModel shipmentC = new ShippingViewModel();

        shipmentC.setName("John Wick");
        shipmentC.setTrackingNumber(111111);

        //Save
        shipmentC = serviceLayer.addShipment(shipmentC);

        //Getting the shipping from service

        ShippingViewModel fromService = serviceLayer.getShipmentByTrackingNumber(shipmentC.getTrackingNumber());

        assertEquals(shipmentC, fromService);
    }
}