package com.iot.controller;

import com.iot.model.dao.implementation.CountryDAO;
import com.iot.model.entity.Country;

import java.sql.SQLException;
import java.util.List;


public class CountryController implements GeneralController<Country> {

  CountryDAO dao = new CountryDAO();

  @Override
  public Country findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public List<Country> findAll() throws SQLException {
    return dao.findAll();
  }


  @Override
  public void create(Country entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Country entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}