package com.iot.controller;

import com.iot.model.dao.implementation.DeliveryDAO;
import com.iot.model.entity.Delivery;

import java.sql.SQLException;
import java.util.List;

public class DeliveryController implements GeneralController<Delivery> {
  DeliveryDAO dao = new DeliveryDAO();

  @Override
  public Delivery findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public List<Delivery> findAll() throws SQLException {
    return dao.findAll();
  }


  @Override
  public void create(Delivery entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Delivery entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }
}
