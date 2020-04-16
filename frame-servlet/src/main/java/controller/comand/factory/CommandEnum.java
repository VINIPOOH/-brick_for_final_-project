package controller.comand.factory;

import controller.comand.action.ActionCommand;
import controller.comand.action.impl.*;
import db.dao.impl.JDBCDaoFactory;
import dto.maper.LoginRequestDtoMapper;
import dto.maper.RegistrationRequestDtoMapper;
import dto.validation.LoginDtoValidator;
import dto.validation.RegistrationDtoValidator;
import service.PasswordEncoderService;
import service.UserService;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new Login(new LoginDtoValidator(), new LoginRequestDtoMapper(), new UserService(new PasswordEncoderService(), JDBCDaoFactory.getUserDao()));
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
    },
    ADMIN {
        {
            this.command=new Admin();
        }
    },
    USER {
        {
            this.command=new User();
        }
    },
    INDEX {
        {
            this.command = new Index();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
