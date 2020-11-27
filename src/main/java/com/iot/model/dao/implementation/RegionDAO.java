package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RegionDAO implements GeneralDAO<Region> {

  private static final String GET_ALL = "SELECT * FROM third_lab.region ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.region WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.region "
          + "(region_name, country_name) VALUES (?,?)";
  private static final String UPDATE = "UPDATE third_lab.region"
          + " SET country_name=?,region_name=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.region WHERE id=?";

  @Override
  public List<Region> findAll() {
    List<Region> regions = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Region region = new Region(
                resultSet.getInt("id"),
                resultSet.getString("country_name"),
                resultSet.getString("region_name")
        );
        regions.add(region);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return regions;
  }

  @Override
  public Region findOne(Integer id) {
    Region region = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        region = new Region(
                resultSet.getInt("id"),
                resultSet.getString("country_name"),
                resultSet.getString("region_name")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return region;
  }

  @Override
  public void create(Region region) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(region.getCountryName()));
      statement.setString(2, String.valueOf(region.getRegionName()));
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Region region) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, region.getRegionName());
      statement.setString(2, region.getCountryName());
      statement.setInt(3, region.getId());
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



