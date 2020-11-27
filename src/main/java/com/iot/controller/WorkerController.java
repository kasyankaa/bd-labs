package com.iot.controller;

import com.iot.model.dao.implementation.WorkerDAO;
import com.iot.model.entity.Worker;

import java.sql.SQLException;
import java.util.List;

public class WorkerController implements GeneralController<Worker> {
  WorkerDAO dao = new WorkerDAO();

  @Override
  public Worker findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public List<Worker> findAll() throws SQLException {
    return dao.findAll();
  }


  @Override
  public void create(Worker entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, Worker entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }
}
