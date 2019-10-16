package com.company.uspsshipmentservice.dao;

import com.company.uspsshipmentservice.model.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShippingDaoJdbcTemplateImplTest {

    @Autowired
    ShippingDao shippingDao;

    @Before
    public void setUp() throws Exception {
        List<Shipment> allShipments = shippingDao.getAllShipments();

        allShipments.stream().forEach(shipment -> shippingDao.deleteShipment(shipment.getShippingId()));
    }

    @Test
    public void addShipment() {
        //Create
        Shipment shipment = new Shipment();
        shipment.setName("John Wick");
        shipment.setTrackingNumber(111111);

        //Save a shipment
        shipment = shippingDao.addShipment(shipment);

        //Get a shipment
        Shipment fromDatabase = shippingDao.getShipment(shipment.getTrackingNumber());

        //Making sure that they are equal
        assertEquals(shipment, fromDatabase);
    }

//    @Test
//    public void getShipment() {
//    }
//
//    @Test
//    public void getAllShipments() {
//    }
}