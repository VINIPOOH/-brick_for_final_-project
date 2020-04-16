package controller.comand.factory;

import db.dao.impl.JDBCDaoFactory;
import dto.RegistrationInfoDto;
import dto.validation.RegistrationDtoValidator;
import dto.validation.Validator;

public class Main {
    public static void main(String[] dd) {
        System.out.println(new RegistrationDtoValidator().isValid(
                new RegistrationInfoDto("aaaaaa","1","1")));
        System.out.println("aaaaaa".matches("([A-Za-z \\d-_.]+)(@[A-Za-z]+)(\\.[A-Za-z]{2,4})"));
    }
}
