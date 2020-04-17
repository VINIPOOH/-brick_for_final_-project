package db.dao.impl;


import db.conection.DbConnectionPoolHolder;
import db.dao.GenericDao;
import db.dao.maper.Mapper;
import exeptions.DBRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class JDBCAbstractGenericDao<E> implements GenericDao<E, Long> {

    protected final Mapper<E> mapper;
    protected final ResourceBundle resourceBundleRequests;
    private final String saveQuery;
    private final String findByIdQuery;
    private final String findAllQuery;
    private final String updateQuery;
    private final String deleteQuery;
    protected DbConnectionPoolHolder connector;


    protected JDBCAbstractGenericDao(DbConnectionPoolHolder connector, Mapper<E> mapper, String saveQuery, String findByIdQuery, String findAllQuery,
                                     String updateQuery, String deleteQuery, ResourceBundle resourceBundleRequests) {
        this.connector = connector;
        this.mapper = mapper;
        this.saveQuery = saveQuery;
        this.findByIdQuery = findByIdQuery;
        this.findAllQuery = findAllQuery;
        this.updateQuery = updateQuery;
        this.deleteQuery = deleteQuery;
        this.resourceBundleRequests = resourceBundleRequests;
    }

    @Override
    public E save(E entity) throws SQLException {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveQuery)) {

            mapper.insertStatementMapper(entity, preparedStatement);
            if (preparedStatement.executeUpdate() != 0) {
                return entity;
            } else {
                throw new SQLException();
            }
        }
    }

    @Override
    public Optional<E> findById(Long id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findByIdQuery)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapper.mapResultSetToEntity(resultSet) : Optional.empty();
        } catch (SQLException e) {
            throw new DBRuntimeException();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DBRuntimeException();
        }
    }

    @Override
    public List<E> findAll(Integer offset, Integer limit) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)) {

            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, limit);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<E> result = new ArrayList<>();

            while (resultSet.next()) {
                mapper.mapResultSetToEntity(resultSet).ifPresent(result::add);
            }
            return result;
        } catch (SQLException e) {
            throw new DBRuntimeException();
        }
    }

    @Override
    public boolean update(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            mapper.updateStatementMapper(entity, preparedStatement);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DBRuntimeException();
        }
    }


}
