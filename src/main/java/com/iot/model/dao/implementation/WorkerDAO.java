package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements GeneralDAO<Worker> {
  private static final String GET_ALL = "SELECT * FROM third_lab.worker ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.worker WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.worker"
          + "(name,surname, phone_number) VALUES (?,?,?)";
  private static final String UPDATE = "UPDATE third_lab.worker"
          + " SET name=?,surname=?,phone_number=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.worker WHERE id=?";

  @Override
  public List<Worker> findAll() {
    List<Worker> workers = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Worker worker = new Worker(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("phone_number")

        );
        workers.add(worker);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return workers;
  }

  @Override
  public Worker findOne(Integer id) {
    Worker worker = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        worker = new Worker(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("phone_number")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return worker;
  }

  @Override
  public void create(Worker worker) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(worker.getName()));
      statement.setString(2, String.valueOf(worker.getSurname()));
      statement.setString(3, String.valueOf(worker.getPhoneNumber()));
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Worker worker) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, worker.getName());
      statement.setString(2, worker.getSurname());
      statement.setString(3, worker.getPhoneNumber());
      statement.setInt(4, worker.getId());
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

