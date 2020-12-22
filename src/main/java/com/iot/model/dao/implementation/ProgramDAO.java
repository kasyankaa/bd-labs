package com.iot.model.dao.implementation;

import com.iot.DataBaseConnector;
import com.iot.model.dao.GeneralDAO;
import com.iot.model.entity.Program;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProgramDAO implements GeneralDAO<Program> {

    private static final String GET_ALL = "SELECT * FROM lab3.program ORDER BY id";
    private static final String GET_ONE = "SELECT * FROM lab3.program WHERE id=?";
    private static final String CREATE = "INSERT  lab3.program "
            + "(company_id,name,language) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE lab3.program"
            + " SET company_id=?,name=?,language=? WHERE id=?";
    private static final String DELETE = "DELETE FROM lab3.program WHERE id=?";

    @Override
    public List<Program> findAll() {
        List<Program> programs = new ArrayList<>();
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Program program = new Program(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("name"),
                        resultSet.getString("language")
                );
                programs.add(program);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return programs;
    }

    @Override
    public Program findOne(Integer id) {
        Program program = null;
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                program = new Program(
                        resultSet.getInt("id"),
                        resultSet.getInt("company_id"),
                        resultSet.getString("name"),
                        resultSet.getString("language")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return program;
    }

    @Override
    public void create(Program program) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, Integer.valueOf(program.getCompanyId()));
            statement.setString(2, String.valueOf(program.getName()));

            statement.setString(3, String.valueOf(program.getLanguage()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Integer id, Program program) throws SQLException {
        try (PreparedStatement statement = DataBaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setString(2, program.getName());
            statement.setInt(4, program.getId());
            statement.setInt(1, program.getCompanyId());
            statement.setString(3, program.getLanguage());
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



