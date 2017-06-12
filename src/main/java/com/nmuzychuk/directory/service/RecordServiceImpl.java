package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;
import com.nmuzychuk.directory.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordServiceImpl implements RecordService {

    private Connection connection;

    public RecordServiceImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Record> getAllRecords() {
        List<Record> recordList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM records";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setFirstName(resultSet.getString("firstName"));
                record.setLastName(resultSet.getString("lastName"));
                record.setPhoneNumber(resultSet.getString("phoneNumber"));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recordList;
    }

    @Override
    public Record getRecord(int id) {
        Record record = new Record();

        try {
            String query = "SELECT * FROM records WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                record.setId(resultSet.getInt("id"));
                record.setFirstName(resultSet.getString("firstName"));
                record.setLastName(resultSet.getString("lastName"));
                record.setPhoneNumber(resultSet.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return record;
    }

    @Override
    public void addRecord(Record record) {
        try {
            String query = "INSERT INTO records(id, firstName, lastName, phoneNumber) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, record.getId());
            preparedStatement.setString(2, record.getFirstName());
            preparedStatement.setString(3, record.getLastName());
            preparedStatement.setString(4, record.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRecord(Record record) {
        try {
            String query = "UPDATE records set id=?, firstName=?, lastName=?, phoneNumber=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, record.getId());
            preparedStatement.setString(2, record.getFirstName());
            preparedStatement.setString(3, record.getLastName());
            preparedStatement.setString(4, record.getPhoneNumber());
            preparedStatement.setInt(5, record.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecord(int id) {
        try {
            String query = "DELETE FROM records where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
