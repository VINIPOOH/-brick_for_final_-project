package db.dao.impl;

import db.conection.DbConnectionPoolHolder;
import db.dao.UserDao;
import db.dao.maper.Mapper;
import entity.User;

import java.util.List;
import java.util.Optional;


public class JDBCUserDao extends JDBCAbstractGenericDao<User> implements UserDao {

    public JDBCUserDao(DbConnectionPoolHolder connector, Mapper<User> mapper, String saveQuery, String findByIdQuery, String findAllQuery, String updateQuery, String deleteQuery) {
        super(connector, mapper, saveQuery, findByIdQuery, findAllQuery, updateQuery, deleteQuery);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
