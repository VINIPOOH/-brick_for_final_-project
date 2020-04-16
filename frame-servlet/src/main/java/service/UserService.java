package service;


import db.dao.UserDao;
import dto.LoginInfoDto;
import dto.RegistrationInfoDto;
import entity.RoleType;
import entity.User;
import exeptions.NoSuchUserException;
import exeptions.OccupiedLoginException;
import exeptions.UsernameNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final PasswordEncoderService passwordEncoderService;
    private final UserDao userDao;

    public UserService(PasswordEncoderService passwordEncoderService, UserDao userDao) {
        this.passwordEncoderService = passwordEncoderService;
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> loginUser(LoginInfoDto loginInfoDto) throws NoSuchUserException {
        User user = userDao.findByEmail(loginInfoDto.getUsername()).orElseThrow(NoSuchUserException::new);
        if (user.isAccountNonExpired()&&user.isAccountNonLocked()&&user.isCredentialsNonExpired()
                &&user.isEnabled()&&user.getPassword().equals(passwordEncoderService.encode(loginInfoDto.getPassword()))){
            return Optional.of(user);
        }

        return Optional.empty();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user with login: " + email));
    }

    public void addNewUserToDB(RegistrationInfoDto registrationInfoDto) throws OccupiedLoginException {
        User user = getMapper().mapToEntity(registrationInfoDto);
        try {
            userDao.save(user);
        } catch (SQLException e) {
            throw new OccupiedLoginException();
        }
    }

    //@Transactional
    public User replenishAccountBalance(long userId, long amountMoney) throws NoSuchUserException, SQLException {
        User user = userDao.findById(userId).orElseThrow(NoSuchUserException::new);
        user.setUserMoneyInCents(user.getUserMoneyInCents() + amountMoney);
        return userDao.save(user);
    }

    private EntityMapper<User, RegistrationInfoDto> getMapper() {
        return (registration) -> User.builder()
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .email(registration.getUsername())
                .enabled(true)
                .userMoneyInCents(0L)
                .password(passwordEncoderService.encode(registration.getPassword()))
                .roleType(RoleType.ROLE_USER)
                .build();
    }
}
