package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.WorkerDelivers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDeliversDAO implements GeneralDAO<WorkerDelivers> {
  private static final String GET_ALL = "SELECT * FROM third_lab.worker_delivers ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.worker_delivers WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.worker_delivers "
          + "(delivery_id,worker_id, address_of_factory,address_of_automat) VALUES (?,?,?,?)";
  private static final String UPDATE = "UPDATE third_lab.worker_delivers"
          + " SET delivery_id=?,worker_id=?,address_of_factory=?,address_of_automat=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.worker_delivers WHERE id=?";

  @Override
  public List<WorkerDelivers> findAll() {
    List<WorkerDelivers> workerDeliveries = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        WorkerDelivers workerDelivers = new WorkerDelivers(
                resultSet.getInt("id"),
                resultSet.getInt("delivery_id"),
                resultSet.getInt("worker_id"),
                resultSet.getString("address_of_factory"),
                resultSet.getString("address_of_automat")

        );
        workerDeliveries.add(workerDelivers);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return workerDeliveries;
  }

  @Override
  public WorkerDelivers findOne(Integer id) {
    WorkerDelivers workerDelivers = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {
      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        workerDelivers = new WorkerDelivers(
                resultSet.getInt("id"),
                resultSet.getInt("delivery_id"),
                resultSet.getInt("worker_id"),
                resultSet.getString("address_of_factory"),
                resultSet.getString("address_of_automat")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return workerDelivers;
  }

  @Override
  public void create(WorkerDelivers workerDelivers) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(workerDelivers.getDeliveryId()));
      statement.setString(2, String.valueOf(workerDelivers.getWorkerId()));
      statement.setString(3, String.valueOf(workerDelivers.getAddressOfFactory()));
      statement.setString(4, String.valueOf(workerDelivers.getAddressOfAutomat()));
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, WorkerDelivers workerDelivers) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setInt(1, workerDelivers.getDeliveryId());
      statement.setInt(2, workerDelivers.getWorkerId());
      statement.setString(3, workerDelivers.getAddressOfFactory());
      statement.setString(4, workerDelivers.getAddressOfAutomat());
      statement.setInt(5, workerDelivers.getId());
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
