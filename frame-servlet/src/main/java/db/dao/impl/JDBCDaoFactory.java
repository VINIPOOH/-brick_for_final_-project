package db.dao.impl;

import db.conection.DbConnectionPoolHolder;
import db.conection.impl.DbConnectorPoolHolderBasicDataSource;
import db.dao.DaoFactory;
import db.dao.UserDao;
import db.dao.maper.UserMapper;

import java.util.ResourceBundle;

import static db.dao.UserDaoConstants.PATH_TO_PROPERTY_FILE;
import static db.dao.UserDaoConstants.USER_SAVE_QUERY;

public class JDBCDaoFactory implements DaoFactory {
    private static DbConnectionPoolHolder dbConnectorPoolHolder = DbConnectorPoolHolderBasicDataSource.getDbConnectionPoolHolder();
    private static UserMapper userMapper = new UserMapper();
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(PATH_TO_PROPERTY_FILE);
    private static UserDao userDao = new JDBCUserDao(dbConnectorPoolHolder, userMapper, resourceBundle.getString(USER_SAVE_QUERY),
            null, null, null, null, resourceBundle);

    public static UserDao getUserDao() {
        return userDao;
    }
}
