package com.iot.controller;

import com.iot.model.dao.implementation.WorkerDeliversDAO;
import com.iot.model.entity.WorkerDelivers;

import java.sql.SQLException;
import java.util.List;

public class WorkerDeliversController implements GeneralController<WorkerDelivers> {
  WorkerDeliversDAO dao = new WorkerDeliversDAO();

  @Override
  public WorkerDelivers findOne(Integer id) throws SQLException {
    return dao.findOne(id);
  }

  @Override
  public List<WorkerDelivers> findAll() throws SQLException {
    return dao.findAll();
  }


  @Override
  public void create(WorkerDelivers entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, WorkerDelivers entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);

  }
}
