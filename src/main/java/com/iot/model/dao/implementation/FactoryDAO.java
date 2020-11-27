package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Factory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryDAO implements GeneralDAO<Factory> {
  private static final String GET_ALL = "SELECT * FROM third_lab.factory ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.factory WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.factory "
          + "(region, address,number_of_workers,phone_number) VALUES (?,?,?,?)";
  private static final String UPDATE = "UPDATE third_lab.factory"
          + " SET region=?,address=?,number_of_workers=?,phone_number=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.factory WHERE id=?";

  @Override
  public List<Factory> findAll() {
    List<Factory> factories = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Factory factory = new Factory(
                resultSet.getInt("id"),
                resultSet.getString("region"),
                resultSet.getString("address"),
                resultSet.getInt("number_of_workers"),
                resultSet.getString("phone_number")
        );
        factories.add(factory);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return factories;
  }

  @Override
  public Factory findOne(Integer id) {
    Factory factory = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        factory = new Factory(
                resultSet.getInt("id"),
                resultSet.getString("region"),
                resultSet.getString("address"),
                resultSet.getInt("number_of_workers"),
                resultSet.getString("phone_number")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return factory;
  }

  @Override
  public void create(Factory factory) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(factory.getRegion()));
      statement.setString(2, String.valueOf(factory.getAddress()));
      statement.setString(3, String.valueOf(factory.getNumberOfWorkers()));
      statement.setString(4, String.valueOf(factory.getPhoneNumber()));
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Factory factory) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, factory.getRegion());
      statement.setString(2, factory.getAddress());
      statement.setInt(3, factory.getNumberOfWorkers());
      statement.setString(4, factory.getPhoneNumber());
      statement.setInt(5, factory.getId());
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      statement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
