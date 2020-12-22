package com.iot.controller;

import com.iot.model.dao.implementation.CompanyDAO;
import com.iot.model.entity.Company;

import java.sql.SQLException;
import java.util.List;


public class CompanyController implements GeneralController<Company> {

    CompanyDAO dao = new CompanyDAO();

    @Override
    public Company findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Company> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Company entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Company entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}