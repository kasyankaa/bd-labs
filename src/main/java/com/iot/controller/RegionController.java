package com.iot.controller;

import com.iot.model.dao.implementation.RegionDAO;
import com.iot.model.entity.Region;

import java.sql.SQLException;
import java.util.List;

public class RegionController implements GeneralController<Region> {
  RegionDAO dao = new RegionDAO();

  @Override
  public List<Region> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public Region findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public void create(Region entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Region entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }

}
