package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanyDAO implements GeneralDAO<Company> {

    private static final String GET_ALL = "SELECT * FROM lab3.company ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM lab3.company WHERE id=?";
    private static final String CREATE = "INSERT  lab3.company "
            + "(name) VALUES (?)";
    private static final String UPDATE = "UPDATE lab3.company"
            + " SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lab3.company WHERE id=?";

    @Override
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public Company findOne(Integer id) {
        Company company = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(Company company) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(company.getName()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Company company) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(2, company.getName());
            statement.setInt(1, company.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}



