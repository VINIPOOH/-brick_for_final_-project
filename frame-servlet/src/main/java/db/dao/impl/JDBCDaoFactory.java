package db.dao.impl;

import db.conection.DbConnectionPoolHolder;
import db.conection.impl.DbConnectorPoolHolderBasicDataSource;
import db.dao.DaoFactory;
import db.dao.UserDao;
import db.dao.maper.UserMapper;

import static db.dao.UserDaoConstants.SAVE_QUERY;

public class JDBCDaoFactory implements DaoFactory {
    private static DbConnectionPoolHolder dbConnectorPoolHolder = DbConnectorPoolHolderBasicDataSource.getDbConnectionPoolHolder();
    private static UserMapper userMapper = new UserMapper();


    @Override
    public UserDao getUserDao() {
        return new JDBCUserDao(dbConnectorPoolHolder, userMapper, SAVE_QUERY,
                null, null, null, null);
    }
}
