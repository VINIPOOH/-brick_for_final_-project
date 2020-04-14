package controller.comand.factory;

import db.dao.impl.JDBCDaoFactory;
import dto.RegistrationInfoDto;
import dto.validation.RegistrationDtoValidator;

public class Main {
    public static void main(String[] dd) {
        JDBCDaoFactory.getUserDao();
    }
}
