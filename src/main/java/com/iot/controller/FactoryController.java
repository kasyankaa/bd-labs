package com.iot.controller;

import com.iot.model.dao.implementation.FactoryDAO;
import com.iot.model.entity.Factory;

import java.sql.SQLException;
import java.util.List;

public class FactoryController implements GeneralController<Factory> {
  FactoryDAO dao = new FactoryDAO();

  @Override
  public Factory findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public List<Factory> findAll() throws SQLException {
    return dao.findAll();
  }


  @Override
  public void create(Factory entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Factory entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }
}
