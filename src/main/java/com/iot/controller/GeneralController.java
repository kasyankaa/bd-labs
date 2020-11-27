package com.iot.controller;

import java.sql.SQLException;
import java.util.List;


public interface GeneralController<E> {

  E findOne(Integer id) throws SQLException;

  List<E> findAll() throws SQLException;

  void create(E entity) throws SQLException;

  void update(Integer id, E entity) throws SQLException;

  void delete(Integer id) throws SQLException;
}