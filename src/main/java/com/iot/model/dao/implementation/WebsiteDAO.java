package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Website;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WebsiteDAO implements GeneralDAO<Website> {

    private static final String GET_ALL = "SELECT * FROM lab3.website ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM lab3.website WHERE id=?";
    private static final String CREATE = "INSERT  lab3.website "
            + "(company_id,link) VALUES (?,?)";
    private static final String UPDATE = "UPDATE lab3.website"
            + " SET company_id=?,link=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lab3.website WHERE id=?";

    @Override
    public List<Website> findAll() {
        List<Website> websites = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Website website = new Website(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("link")
                );
                websites.add(website);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return websites;
    }

    @Override
    public Website findOne(Integer id) {
        Website website = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                website = new Website(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("link")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return website;
    }

    @Override
    public void create(Website website) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setString(2, String.valueOf(website.getLink()));
            statement.setInt(1, Integer.valueOf(website.getCompanyId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Website website) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(2, website.getLink());
            statement.setInt(1, website.getCompanyId());

            statement.setInt(3, website.getId());
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



