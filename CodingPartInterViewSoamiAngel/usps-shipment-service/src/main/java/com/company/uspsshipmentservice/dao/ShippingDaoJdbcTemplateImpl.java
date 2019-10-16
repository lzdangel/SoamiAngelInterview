package com.company.uspsshipmentservice.dao;

import com.company.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShippingDaoJdbcTemplateImpl implements ShippingDao{

    //Prepared statements
    public static final String INSERT_SHIPMENT =
            "insert into shipment (customer_name, tracking_number) values (?, ?)";

    public static final String SELECT_SHIPMENT_BY_TRACKING_NUMBER =
            "select * from shipment where tracking_number = ?";

    public static final String SELECT_ALL_SHIPMENTS=
            "select * from shipment";

    public static final String DELETE_SHIPMENT =
            "delete from shipment where shipping_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ShippingDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Shipment addShipment(Shipment shipment) {
        jdbcTemplate.update(INSERT_SHIPMENT,
                shipment.getName(),
                shipment.getTrackingNumber()
                );

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        shipment.setShippingId(id);

        return shipment;
    }

    @Override
    public Shipment getShipment(int trackingNumber) {

        try{
            return jdbcTemplate.queryForObject(SELECT_SHIPMENT_BY_TRACKING_NUMBER, this::mapRowToShipment, trackingNumber);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Shipment> getAllShipments() {
        return jdbcTemplate.query(SELECT_ALL_SHIPMENTS, this::mapRowToShipment);
    }

    @Override
    public void deleteShipment(int id) {
        jdbcTemplate.update(DELETE_SHIPMENT, id);
    }

    //Helper methods

    private Shipment mapRowToShipment(ResultSet rs, int rowNum) throws SQLException {

        Shipment shipment = new Shipment();

        shipment.setShippingId(rs.getInt("shipping_id"));
        shipment.setName(rs.getString("customer_name"));
        shipment.setTrackingNumber(rs.getInt("tracking_number"));

        return shipment;
    }
}
