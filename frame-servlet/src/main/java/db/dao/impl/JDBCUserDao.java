package db.dao.impl;

import db.conection.DbConnectionPoolHolder;
import db.dao.UserDao;
import db.dao.UserDaoConstants;
import db.dao.maper.Mapper;
import entity.User;
import exeptions.DBRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class JDBCUserDao extends JDBCAbstractGenericDao<User> implements UserDao, UserDaoConstants {

    public JDBCUserDao(DbConnectionPoolHolder connector, Mapper<User> mapper, String saveQuery, String findByIdQuery, String findAllQuery, String updateQuery, String deleteQuery, ResourceBundle resourceBundleRequests) {
        super(connector, mapper, saveQuery, findByIdQuery, findAllQuery, updateQuery, deleteQuery, resourceBundleRequests);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(resourceBundleRequests.getString(USER_FIND_BY_EMAIL))) {
            System.out.println("try start");
            preparedStatement.setString(1, email);
            System.out.println("pre resultset");
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("post result set");
            Optional<User> user = resultSet.next() ? mapper.mapResultSetToEntity(resultSet) : Optional.empty();
            System.out.println(user.toString());
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(e.getStackTrace());
            System.out.println(e.getSQLState().toString());
            System.out.println(e.getNextException().getSQLState());
            throw new DBRuntimeException();
        }catch (Exception ex){
            System.out.println("ex 2");
            throw new DBRuntimeException();
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
