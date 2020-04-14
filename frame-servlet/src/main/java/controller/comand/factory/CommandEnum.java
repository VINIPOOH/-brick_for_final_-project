package controller.comand.factory;

import controller.comand.action.ActionCommand;
import controller.comand.action.impl.LogOut;
import controller.comand.action.impl.Login;
import controller.comand.action.impl.Registration;
import db.conection.impl.DbConnectorPoolHolderBasicDataSource;
import db.dao.impl.JDBCDaoFactory;
import db.dao.impl.JDBCUserDao;
import dto.maper.RegistrationRequestDtoMapper;
import dto.validation.RegistrationDtoValidator;
import service.PasswordEncoderService;
import service.UserService;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new Login();
        }
    },
    LOGOUT {
        {
            this.command = new LogOut();
        }
    },
    REGISTRATION {
        {
            this.command = new Registration(new RegistrationRequestDtoMapper(),
                    new RegistrationDtoValidator(), new UserService(new PasswordEncoderService(), JDBCDaoFactory.getUserDao()));
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
