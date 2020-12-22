package com.iot.controller;

import com.iot.model.dao.implementation.ProgramDAO;

import com.iot.model.entity.Program;


import java.sql.SQLException;
import java.util.List;


public class ProgramController implements GeneralController<Program> {

    ProgramDAO dao = new ProgramDAO();

    @Override
    public Program findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Program> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Program entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Program entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}