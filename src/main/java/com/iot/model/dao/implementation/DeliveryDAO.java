package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Delivery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO implements GeneralDAO<Delivery> {
  private static final String GET_ALL = "SELECT * FROM third_lab.delivery ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.delivery WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.delivery "
          + "(factory_id, car_number) VALUES (?,?)";
  private static final String UPDATE = "UPDATE third_lab.delivery"
          + " SET factory_id=?,car_number=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.delivery WHERE id=?";

  @Override
  public List<Delivery> findAll() {
    List<Delivery> deliveries = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Delivery delivery = new Delivery(
                resultSet.getInt("id"),
                resultSet.getInt("factory_id"),
                resultSet.getString("car_number")

        );
        deliveries.add(delivery);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return deliveries;
  }

  @Override
  public Delivery findOne(Integer id) {
    Delivery delivery = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        delivery = new Delivery(
                resultSet.getInt("id"),
                resultSet.getInt("factory_id"),
                resultSet.getString("car_number")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return delivery;
  }

  @Override
  public void create(Delivery delivery) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(delivery.getFactoryId()));
      statement.setString(2, String.valueOf(delivery.getCarNumber()));

      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Delivery delivery) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setInt(1, delivery.getFactoryId());
      statement.setString(2, delivery.getCarNumber());
      statement.setInt(3, delivery.getId());
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
