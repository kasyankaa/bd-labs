package com.iot.model.dao.implementation;

import com.iot.DatabaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CountryDAO implements GeneralDAO<Country> {

  private static final String GET_ALL = "SELECT * FROM third_lab.country ORDER BY id";
  private static final String GET_ONE = "SELECT * FROM third_lab.country WHERE id=?";
  private static final String CREATE = "INSERT  third_lab.country "
          + "(country_name) VALUES (?)";
  private static final String UPDATE = "UPDATE third_lab.country"
          + " SET country_name=? WHERE id=?";
  private static final String DELETE = "DELETE FROM third_lab.country WHERE id=?";

  @Override
  public List<Country> findAll() {
    List<Country> countries = new ArrayList<>();
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Country country = new Country(
                resultSet.getInt("id"),
                resultSet.getString("country_name")
        );
        countries.add(country);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return countries;
  }

  @Override
  public Country findOne(Integer id) {
    Country country = null;
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

      statement.setInt(1, id);
      System.out.println(statement);
      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        country = new Country(
                resultSet.getInt("id"),
                resultSet.getString("country_name")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return country;
  }

  @Override
  public void create(Country country) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, String.valueOf(country.getCountryName()));
      statement.executeUpdate();
      System.out.println(statement);
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  @Override
  public void update(Integer id, Country country) throws SQLException {
    try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, country.getCountryName());
      statement.setInt(2, country.getId());
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



