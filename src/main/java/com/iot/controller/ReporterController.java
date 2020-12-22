package com.iot.controller;

import com.iot.model.dao.implementation.ReporterDAO;
import com.iot.model.entity.Reporter;

import java.sql.SQLException;
import java.util.List;

public class ReporterController implements GeneralController<Reporter> {
    ReporterDAO dao = new ReporterDAO();

    @Override
    public List<Reporter> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Reporter findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Reporter entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Reporter entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}
