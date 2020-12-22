package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Reporter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporterDAO implements GeneralDAO<Reporter> {

    private static final String GET_ALL = "SELECT * FROM lab3.reporter ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM lab3.reporter WHERE id=?";
    private static final String CREATE = "INSERT  lab3.reporter "
            + "(program_id,first_name,last_name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE lab3.reporter"
            + " SET program_id=?,first_name=?,last_name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lab3.reporter WHERE id=?";

    @Override
    public List<Reporter> findAll() {
        List<Reporter> programs = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Reporter program = new Reporter(
                        resultSet.getInt("id"),
                        resultSet.getInt("program_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                programs.add(program);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programs;
    }

    @Override
    public Reporter findOne(Integer id) {
        Reporter reporter = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reporter = new Reporter(
                        resultSet.getInt("id"),
                        resultSet.getInt("program_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporter;
    }

    @Override
    public void create(Reporter reporter) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, Integer.valueOf(reporter.getProgramId()));
            statement.setString(2, String.valueOf(reporter.getFirst_name()));
            statement.setString(3, String.valueOf(reporter.getLast_name()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Reporter reporter) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(2,reporter.getFirst_name());
            statement.setInt(4, reporter.getId());
            statement.setInt(1, reporter.getProgramId());
            statement.setString(3, reporter.getLast_name());
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



