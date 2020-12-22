package com.iot.controller;

import com.iot.model.dao.implementation.WebsiteDAO;

import com.iot.model.entity.Website;


import java.sql.SQLException;
import java.util.List;


public class WebsiteController implements GeneralController<Website> {

    WebsiteDAO dao = new WebsiteDAO();

    @Override
    public Website findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public List<Website> findAll() throws SQLException {
        return dao.findAll();
    }


    @Override
    public void create(Website entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Website entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}